package kr.co.pawong.pwsb.lostPost.adapter.out.messaging;

import kr.co.pawong.pwsb.infrastructure.messaging.application.port.in.PublishMessageUseCase;
import kr.co.pawong.pwsb.lostPost.application.port.out.LostAnimalMessagePublishPort;
import kr.co.pawong.pwsb.lostPost.application.port.out.dto.CreatedLostAnimalPublishDto;
import kr.co.pawong.pwsb.lostPost.enums.PostType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LostAnimalMessagePublisher implements LostAnimalMessagePublishPort {

    @Value("${kafka.topic.rescued-animal-created}")
    private String RESCUED_ANIMAL_CREATED_TOPIC;

    private final PublishMessageUseCase publishMessageUseCase;

    @Override
    public void publishLostAnimalCreatedMessage(CreatedLostAnimalPublishDto message) {
        if (message.type() == PostType.FOSTER) {
            publishMessageUseCase.publishMessage(RESCUED_ANIMAL_CREATED_TOPIC, message);
        }
    }
}
