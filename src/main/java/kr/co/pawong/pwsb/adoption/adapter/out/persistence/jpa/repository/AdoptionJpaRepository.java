package kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa.repository;

import java.util.List;
import java.util.Optional;
import kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa.entity.AdoptionEntity;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdoptionJpaRepository extends JpaRepository<AdoptionEntity, Long> {

    // adoptionId에 해당하는 AdoptionEntity의 refinedSpecialMark, tagsField, isAiProcessed 업데이트
    @Modifying(clearAutomatically = true)
    @Query("UPDATE AdoptionEntity a SET a.refinedSpecialMark = :refinedSpecialMark, a.tagsField = :tagsField, a.isAiProcessed = :isAiProcessed WHERE a.adoptionId = :adoptionId")
    void updateAiFields(
            @Param("adoptionId") Long adoptionId,
            @Param("refinedSpecialMark") String refinedSpecialMark,
            @Param("tagsField") String tagsField,
            @Param("isAiProcessed") boolean isAiProcessed);

    @Query("SELECT a.careRegNo FROM AdoptionEntity a WHERE a.adoptionId = :id")
    String findCareRegNoByAdoptionId(@Param("id") Long id);

    Optional<AdoptionEntity> findByAdoptionId(Long adoptionId);

    List<AdoptionEntity> findAllByDesertionNo(String desertionNo);

    Optional<AdoptionEntity> findByDesertionNo(String desertionNo);

    // id가 같으면 isEmbedded 업데이트
    @Modifying
    @Query("UPDATE AdoptionEntity a SET a.isEmbedded = true WHERE a.adoptionId IN :ids")
    void updateIsEmbeddedByIds(@Param("ids") List<Long> ids);

    // ActiveState가 MISSING, ADOPTED인 것과 IsProcessed가 False
    List<AdoptionEntity> findByActiveStateInAndIsAiProcessedFalse(List<ActiveState> activeStates);
}
