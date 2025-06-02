package kr.co.pawong.pwsb.infrastructure.messaging.application.port.in;

public interface PublishMessageUseCase {

    void publishMessage(String topic, Object message);
}
