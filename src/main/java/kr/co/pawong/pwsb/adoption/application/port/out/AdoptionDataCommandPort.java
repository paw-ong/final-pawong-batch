package kr.co.pawong.pwsb.adoption.application.port.out;

import java.util.List;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;

public interface AdoptionDataCommandPort {

    void updateIsEmbeddedByIds(List<Long> ids);

    void updateAiFields(List<Adoption> adoptions);

    void updateAdoption(Adoption adoption);

    void saveAdoption(Adoption adoption);

    void deleteAdoption(Adoption adoption);
}
