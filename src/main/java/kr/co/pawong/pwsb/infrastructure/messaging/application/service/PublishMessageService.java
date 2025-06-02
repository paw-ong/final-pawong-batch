package kr.co.pawong.pwsb.infrastructure.messaging.application.service;

import kr.co.pawong.pwsb.infrastructure.messaging.application.port.in.PublishMessageUseCase;
import kr.co.pawong.pwsb.infrastructure.messaging.application.port.out.MessagePublishPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishMessageService implements PublishMessageUseCase {

    private final MessagePublishPort messagePublishPort;

    @Override
    public void publishMessage(String topic, Object message) {
        messagePublishPort.publishMessage(topic, message);
    }
}
