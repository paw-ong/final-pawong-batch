package kr.co.pawong.pwsb.adoption.adapter.out.shelter;

import kr.co.pawong.pwsb.adoption.application.port.out.ShelterCommandPort;
import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionCareDto;
import kr.co.pawong.pwsb.shelter.application.port.in.UpdateShelterDataUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShelterCommandAdapter implements ShelterCommandPort {

    private final UpdateShelterDataUseCase updateShelterDataUseCase;

    @Override
    public void processShelterInfo(AdoptionCareDto adoptionCareDto) {
        updateShelterDataUseCase.updateShelterIfNotExist(adoptionCareDto);
    }
}
