package kr.co.pawong.pwsb.shelter.application.port.out;

import kr.co.pawong.pwsb.shelter.domain.Shelter;

public interface ShelterDataQueryPort {

    Shelter findByCareRegNoOrThrow(String careRegNo);

    boolean existsByCareRegNo(String careRegNo);
}
