package kr.co.pawong.pwsb.batch.listener;

import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import kr.co.pawong.pwsb.infrastructure.api.dto.AdoptionCreate;
import kr.co.pawong.pwsb.lostPost.application.port.in.PublishCreatedLostAnimalUseCase;
import kr.co.pawong.pwsb.lostPost.enums.PostType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RescuedAnimalPublishListener implements ItemWriteListener<AdoptionCreate> {

    private final PublishCreatedLostAnimalUseCase publishCreatedLostAnimalUseCase;

    @Override
    public void afterWrite(Chunk<? extends AdoptionCreate> items) {
        int count = 0;
        for (AdoptionCreate item : items) {
            if (item.getRdbId() != null) {
                publishMissingAdoption(item.getRdbId(), Adoption.from(item));
                count++;
            }
        }
        log.info("LostAdoption Created {}개 발행", count);
    }

    private void publishMissingAdoption(long id, Adoption adoption) {
        if (adoption.getActiveState() == ActiveState.MISSING) {
            // 특징 문자열 생성
            String textFeature = String.join(" ",
                    adoption.getColorCd(),
                    adoption.getKindNm(),
                    adoption.getUpKindNm().name());
            // 구조 동물 추가됐다는 메시지 발행
            publishCreatedLostAnimalUseCase.publishCreatedLostAnimal(
                    id,
                    PostType.FOSTER,
                    textFeature,
                    adoption.getPopfile1()
            );
        }
    }

}
