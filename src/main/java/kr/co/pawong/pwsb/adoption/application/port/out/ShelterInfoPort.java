package kr.co.pawong.pwsb.adoption.application.port.out;

import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;

public interface ShelterInfoPort {

    ShelterInfoDto getShelterInfo(String careRegNo);
}
