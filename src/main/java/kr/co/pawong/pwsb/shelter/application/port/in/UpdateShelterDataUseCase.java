package kr.co.pawong.pwsb.shelter.application.port.in;

import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionCareDto;

public interface UpdateShelterDataUseCase {

    void updateShelterIfNotExist(AdoptionCareDto adoptionCareDto);
}
