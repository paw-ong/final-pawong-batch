package kr.co.pawong.pwsb.lostPost.application.port.in;

import kr.co.pawong.pwsb.lostPost.enums.PostType;

public interface PublishCreatedLostAnimalUseCase {

    void publishCreatedLostAnimal(
            long id,
            PostType type,
            String queryText,
            String queryImageUrl
    );
}
