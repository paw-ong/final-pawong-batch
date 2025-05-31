package kr.co.pawong.pwsb.adoption.adapter.out.shelter;

import kr.co.pawong.pwsb.adoption.application.port.out.ShelterInfoPort;
import kr.co.pawong.pwsb.shelter.application.port.in.QueryShelterDataUseCase;
import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShelterInfoAdapter implements ShelterInfoPort {

    private final QueryShelterDataUseCase queryShelterDataUseCase;

    @Override
    public ShelterInfoDto getShelterInfo(String careRegNo) {
        ShelterInfoDto shelterInfoDto = queryShelterDataUseCase.shelterInfo(careRegNo);
        if (shelterInfoDto == null) {
            log.warn("ShelterInfo not found for careRegNo: {}", careRegNo);
            return null; // 또는 예외 throw
        }
        return shelterInfoDto; // 또는 예외 throw
    }
}
