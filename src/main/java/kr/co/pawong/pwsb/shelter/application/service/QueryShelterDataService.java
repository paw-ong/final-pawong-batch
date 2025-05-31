package kr.co.pawong.pwsb.shelter.application.service;

import kr.co.pawong.pwsb.shelter.application.port.in.QueryShelterDataUseCase;
import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;
import kr.co.pawong.pwsb.shelter.application.port.out.ShelterDataQueryPort;
import kr.co.pawong.pwsb.shelter.domain.Shelter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryShelterDataService implements QueryShelterDataUseCase {

    private final ShelterDataQueryPort shelterDataQueryPort;

    @Override
    public ShelterInfoDto shelterInfo(String careRegNo) {
        Shelter shelter = shelterDataQueryPort.findByCareRegNoOrThrow(careRegNo);

        ShelterInfoDto shelterInfoDto = ShelterInfoDto.from(shelter);

        if (shelterInfoDto == null) {
            return new ShelterInfoDto(careRegNo, "", "");
        }

        return shelterInfoDto;
    }
}
