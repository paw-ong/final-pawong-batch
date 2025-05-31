package kr.co.pawong.pwsb.adoption.application.port.out;

import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionCareDto;

public interface ShelterCommandPort {

    void processShelterInfo(AdoptionCareDto adoptionCareDto);
}
