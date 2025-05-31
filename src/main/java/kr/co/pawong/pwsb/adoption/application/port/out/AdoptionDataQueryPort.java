package kr.co.pawong.pwsb.adoption.application.port.out;

import java.util.List;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;

public interface AdoptionDataQueryPort {
    // AdoptionEntity -> Adoption
    List<Adoption> findAll();

    String findCareRegNoByAdoptionId(Long adoptionId);

    List<Adoption> findAllByDesertionNo(String desertionNo);

    List<Adoption> findByActiveStateInAndAiProcessedFalse();
}
