package kr.co.pawong.pwsb.batch.processor;

import kr.co.pawong.pwsb.adoption.application.port.in.CommandAdoptionDataUseCase;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdoptionAiProcessor implements ItemProcessor<Adoption, Adoption> {
    private final CommandAdoptionDataUseCase commandAdoptionDataUseCase;
    @Override
    public Adoption process(Adoption adoption) {
        // AI 정제
        return commandAdoptionDataUseCase.processAdoption(adoption);
    }
}
