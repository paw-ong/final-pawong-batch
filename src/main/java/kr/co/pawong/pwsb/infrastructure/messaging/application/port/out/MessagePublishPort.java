package kr.co.pawong.pwsb.infrastructure.messaging.application.port.out;

public interface MessagePublishPort {

    void publishMessage(String topic, Object message);
}
