package kr.co.pawong.pwsb.adoption.application.port.in;

import kr.co.pawong.pwsb.adoption.application.service.dto.AdoptionApi;
import kr.co.pawong.pwsb.infrastructure.api.dto.AdoptionCreate;

public interface ApiAdoptionUseCase {

    AdoptionCreate convertToAdoptionCreate(AdoptionApi.Item item);

    AdoptionApi.Item fetchNextAdoptionItem();

    void extractAndProcessShelterInfo(AdoptionApi.Item item);
}
