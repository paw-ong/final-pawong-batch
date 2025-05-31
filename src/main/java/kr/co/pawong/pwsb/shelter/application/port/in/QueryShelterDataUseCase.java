package kr.co.pawong.pwsb.shelter.application.port.in;

import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;

public interface QueryShelterDataUseCase {

    ShelterInfoDto shelterInfo(String careRegNo);

}
