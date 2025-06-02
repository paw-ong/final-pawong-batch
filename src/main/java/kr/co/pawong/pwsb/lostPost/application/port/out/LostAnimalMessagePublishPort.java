package kr.co.pawong.pwsb.lostPost.application.port.out;

import kr.co.pawong.pwsb.lostPost.application.port.out.dto.CreatedLostAnimalPublishDto;

public interface LostAnimalMessagePublishPort {

    void publishLostAnimalCreatedMessage(CreatedLostAnimalPublishDto message);
}
