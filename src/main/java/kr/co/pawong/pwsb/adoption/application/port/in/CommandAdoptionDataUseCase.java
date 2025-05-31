package kr.co.pawong.pwsb.adoption.application.port.in;

import java.util.List;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.infrastructure.api.dto.AdoptionCreate;

public interface CommandAdoptionDataUseCase {

    void saveAdoptions(List<AdoptionCreate> adoptionCreates);

    Adoption processAdoption(Adoption adoption);
}
