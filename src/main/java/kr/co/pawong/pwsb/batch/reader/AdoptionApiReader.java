package kr.co.pawong.pwsb.batch.reader;

import kr.co.pawong.pwsb.adoption.application.port.in.ApiAdoptionUseCase;
import kr.co.pawong.pwsb.adoption.application.service.dto.AdoptionApi;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
@StepScope
@RequiredArgsConstructor
public class AdoptionApiReader implements ItemReader<AdoptionApi.Item> {
    private final ApiAdoptionUseCase apiAdoptionUseCase;

    @Override
    public AdoptionApi.Item read() {
        return apiAdoptionUseCase.fetchNextAdoptionItem();
    }
}
