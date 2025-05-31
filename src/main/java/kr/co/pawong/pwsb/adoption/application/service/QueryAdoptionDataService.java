package kr.co.pawong.pwsb.adoption.application.service;

import java.util.List;
import kr.co.pawong.pwsb.adoption.application.port.in.QueryAdoptionDataUseCase;
import kr.co.pawong.pwsb.adoption.application.port.out.AdoptionDataQueryPort;
import kr.co.pawong.pwsb.adoption.application.port.out.ShelterInfoPort;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class  QueryAdoptionDataService implements QueryAdoptionDataUseCase {

    private final AdoptionDataQueryPort adoptionDataQueryPort;
    private final ShelterInfoPort shelterInfoPort;

    // AI 정제할 adoption 조회
    @Override
    public List<Adoption> findActiveNotProcessedAdoptions() {
        return adoptionDataQueryPort.findByActiveStateInAndAiProcessedFalse();
    }

    // 임베딩할 adoption 조회
    @Override
    public List<Adoption> findAdoptionForEmbedding() {
        return adoptionDataQueryPort.findAll().stream()
                .filter(adoption -> adoption.isAiProcessed()
                        && !adoption.isEmbedded())
                .toList();
    }

    // 보호소 정보를 찾을 adoptionId 조회
    @Override
    public ShelterInfoDto findShelterInfoByAdoptionId(Long adoptionId) {
        // 1) AdoptionEntity에서 careRegNo 조회
        String careRegNo = adoptionDataQueryPort.findCareRegNoByAdoptionId(adoptionId);
        if (careRegNo == null) {
            log.warn("careRegNo not found for adoptionId: {}", adoptionId);
            return null; // 또는 예외 throw
        }
        // 2) ShelterAdapter 통해 실제 Shelter 컨텍스트에 질의
        return shelterInfoPort.getShelterInfo(careRegNo);
    }
}
