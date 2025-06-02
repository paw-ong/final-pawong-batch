package kr.co.pawong.pwsb.lostPost.adapter.out.persistence.es;

import kr.co.pawong.pwsb.lostPost.adapter.out.persistence.es.repository.EsLostAnimalRepository;
import kr.co.pawong.pwsb.lostPost.application.port.out.LostAnimalEngineCommandPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class EsLostAnimalEngineCommandAdapter implements LostAnimalEngineCommandPort {

    private final EsLostAnimalRepository esLostAnimalRepository;

    @Override
    public void deleteLostAnimalByAdoptionId(Long adoptionId) {
        try {
            String lostAnimalId = "FOSTER_" + adoptionId;
            esLostAnimalRepository.deleteById(lostAnimalId);
            log.info("LostAnimal ES 삭제 성공: lostAnimalId={}", lostAnimalId);
        } catch (Exception e) {
            log.error("LostAnimal ES 삭제 실패: adoptionId={}, lostAnimalId=FOSTER_{}", adoptionId, adoptionId, e);
            throw new RuntimeException("LostAnimal ES 삭제 실패", e);
        }
    }
}
