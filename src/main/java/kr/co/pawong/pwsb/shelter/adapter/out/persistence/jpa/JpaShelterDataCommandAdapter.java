package kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa;

import kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa.entity.ShelterEntity;
import kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa.repository.ShelterJpaRepository;
import kr.co.pawong.pwsb.shelter.application.port.out.ShelterDataCommandPort;
import kr.co.pawong.pwsb.shelter.domain.Shelter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JpaShelterDataCommandAdapter implements ShelterDataCommandPort {

    private final ShelterJpaRepository shelterJpaRepository;

    @Override
    public void saveShelter(Shelter shelter) {

        ShelterEntity shelterEntity = ShelterEntity.from(shelter);
        shelterJpaRepository.save(shelterEntity);
        log.info("보호소 정보 저장 완료: id={}, careRegNo={}, name={}",
                shelterEntity.getShelterId(), shelterEntity.getCareRegNo(),
                shelterEntity.getCareNm());
    }
}
