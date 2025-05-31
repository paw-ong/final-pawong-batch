package kr.co.pawong.pwsb.shelter.application.port.out;

import kr.co.pawong.pwsb.shelter.domain.Shelter;

public interface ShelterDataCommandPort {

    void saveShelter(Shelter shelter);
}
