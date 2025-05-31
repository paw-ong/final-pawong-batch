package kr.co.pawong.pwsb.batch.processor;

import kr.co.pawong.pwsb.adoption.application.port.in.ApiAdoptionUseCase;
import kr.co.pawong.pwsb.adoption.application.service.dto.AdoptionApi;
import kr.co.pawong.pwsb.infrastructure.api.dto.AdoptionCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdoptionApiProcessor implements ItemProcessor<AdoptionApi.Item, AdoptionCreate> {
    private final ApiAdoptionUseCase apiAdoptionUseCase;

    @Override
    public AdoptionCreate process(AdoptionApi.Item item) {
        // 보호소 정보 추출 및 처리
        apiAdoptionUseCase.extractAndProcessShelterInfo(item);

        return apiAdoptionUseCase.convertToAdoptionCreate(item);
    }
}
