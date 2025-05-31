package kr.co.pawong.pwsb.adoption.application.port.in;

import java.util.List;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;

public interface QueryAdoptionDataUseCase {

    List<Adoption> findActiveNotProcessedAdoptions();

    List<Adoption> findAdoptionForEmbedding();

    ShelterInfoDto findShelterInfoByAdoptionId(Long adoptionId);
}
