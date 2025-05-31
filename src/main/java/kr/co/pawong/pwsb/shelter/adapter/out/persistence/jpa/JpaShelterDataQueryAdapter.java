package kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa;

import kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa.entity.ShelterEntity;
import kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa.repository.ShelterJpaRepository;
import kr.co.pawong.pwsb.shelter.application.port.out.ShelterDataQueryPort;
import kr.co.pawong.pwsb.shelter.domain.Shelter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JpaShelterDataQueryAdapter implements ShelterDataQueryPort {

    private final ShelterJpaRepository shelterJpaRepository;

    @Override
    public Shelter findByCareRegNoOrThrow(String careRegNo) {
        return shelterJpaRepository.findByCareRegNo(careRegNo)
                .map(ShelterEntity::toModel)
                .orElse(null);
    }

    @Override
    public boolean existsByCareRegNo(String careRegNo) {
        return shelterJpaRepository.existsByCareRegNo(careRegNo);
    }
}
