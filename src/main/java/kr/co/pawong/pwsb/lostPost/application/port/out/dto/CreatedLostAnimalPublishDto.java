package kr.co.pawong.pwsb.lostPost.application.port.out.dto;

import kr.co.pawong.pwsb.lostPost.enums.PostType;
import lombok.Builder;

@Builder
public record CreatedLostAnimalPublishDto(
        long id,
        PostType type,
        String queryText,
        String queryImageUrl
) {

}
