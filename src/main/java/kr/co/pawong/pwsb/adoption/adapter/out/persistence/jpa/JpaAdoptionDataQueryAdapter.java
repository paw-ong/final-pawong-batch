package kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa;

import java.util.List;
import java.util.stream.Collectors;
import kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa.entity.AdoptionEntity;
import kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa.repository.AdoptionJpaRepository;
import kr.co.pawong.pwsb.adoption.application.port.out.AdoptionDataQueryPort;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaAdoptionDataQueryAdapter implements AdoptionDataQueryPort {

    private final AdoptionJpaRepository adoptionJpaRepository;

    /**
     * DB에 저장된 모든 AdoptionEntity를 Adoption 도메인 객체로 변환하여 반환
     */
    @Override
    public List<Adoption> findAll() {
        return adoptionJpaRepository.findAll().stream()
                .map(AdoptionEntity::toModel)
                .toList();
    }

    @Override
    public String findCareRegNoByAdoptionId(Long adoptionId) {
        return adoptionJpaRepository.findCareRegNoByAdoptionId(adoptionId);
    }

    @Override
    public List<Adoption> findAllByDesertionNo(String desertionNo) {
        return adoptionJpaRepository.findAllByDesertionNo(desertionNo)
                .stream()
                .map(AdoptionEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Adoption> findByActiveStateInAndAiProcessedFalse() {
        List<AdoptionEntity> entities = adoptionJpaRepository.findByActiveStateInAndIsAiProcessedFalse(
                List.of(ActiveState.ADOPTABLE, ActiveState.MISSING));

        return entities.stream()
                .map(AdoptionEntity::toModel)
                .collect(Collectors.toList());
    }
}
