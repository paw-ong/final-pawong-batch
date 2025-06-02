package kr.co.pawong.pwsb.lostPost.application.service;

import kr.co.pawong.pwsb.lostPost.application.port.in.PublishCreatedLostAnimalUseCase;
import kr.co.pawong.pwsb.lostPost.application.port.out.LostAnimalMessagePublishPort;
import kr.co.pawong.pwsb.lostPost.application.port.out.dto.CreatedLostAnimalPublishDto;
import kr.co.pawong.pwsb.lostPost.enums.PostType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishCreatedLostAnimalService implements PublishCreatedLostAnimalUseCase {

    private final LostAnimalMessagePublishPort lostAnimalMessagePublishPort;

    @Override
    public void publishCreatedLostAnimal(long id, PostType type, String queryText,
            String queryImageUrl) {
        lostAnimalMessagePublishPort.publishLostAnimalCreatedMessage(
                new CreatedLostAnimalPublishDto(id, type, queryText, queryImageUrl)
        );
    }
}
