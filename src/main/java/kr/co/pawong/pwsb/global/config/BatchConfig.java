package kr.co.pawong.pwsb.global.config;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionEsDto;
import kr.co.pawong.pwsb.adoption.application.service.dto.AdoptionApi;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.batch.listener.RescuedAnimalPublishListener;
import kr.co.pawong.pwsb.batch.listener.StepListener;
import kr.co.pawong.pwsb.batch.processor.AdoptionAiProcessor;
import kr.co.pawong.pwsb.batch.processor.AdoptionApiProcessor;
import kr.co.pawong.pwsb.batch.processor.AdoptionEsProcessor;
import kr.co.pawong.pwsb.batch.reader.AdoptionAiReader;
import kr.co.pawong.pwsb.batch.reader.AdoptionApiReader;
import kr.co.pawong.pwsb.batch.reader.AdoptionEsReader;
import kr.co.pawong.pwsb.batch.writer.AdoptionAiWriter;
import kr.co.pawong.pwsb.batch.writer.AdoptionApiWriter;
import kr.co.pawong.pwsb.batch.writer.AdoptionEsWriter;
import kr.co.pawong.pwsb.infrastructure.api.dto.AdoptionCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfig {

     private final StepListener stepListener;
     private final RescuedAnimalPublishListener rescuedAnimalPublishListener;

    @Bean
    public Job adoptionApiJob(JobRepository jobRepository,
            Step adoptionApiStep,
            Step aiProcessedStep,
            Step saveEsStep) {
        return new JobBuilder("adoptionApiJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(adoptionApiStep)
                .next(aiProcessedStep)
                .next(saveEsStep)
                .build();
    }

    @Bean
    public Step adoptionApiStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
            AdoptionApiReader reader,
            AdoptionApiProcessor processor,
            AdoptionApiWriter writer) {
        return new StepBuilder("adoptionApiStep", jobRepository)
                .<AdoptionApi.Item, AdoptionCreate>chunk(100, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(50)
                .retry(TransientDataAccessException.class)
                .retryLimit(3)
                .startLimit(3)
                .listener(rescuedAnimalPublishListener)
                .listener(stepListener)
                .build();
    }

    @Bean
    public Step aiProcessedStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
            AdoptionAiReader reader,
            AdoptionAiProcessor processor,
            AdoptionAiWriter writer) {
        return new StepBuilder("aiProcessedStep", jobRepository)
                .<Adoption, Adoption>chunk(20, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(25)
                .startLimit(2)
                .listener(stepListener)
                .build();
    }

    @Bean
    public Step saveEsStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
            AdoptionEsReader reader,
            AdoptionEsProcessor processor,
            AdoptionEsWriter writer) {
        return new StepBuilder("saveEsStep", jobRepository)
                .<Adoption, AdoptionEsDto>chunk(50, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(10)
                .retry(ElasticsearchException.class)
                .retryLimit(3)
                .startLimit(3)
                .listener(stepListener)
                .build();
    }
}
