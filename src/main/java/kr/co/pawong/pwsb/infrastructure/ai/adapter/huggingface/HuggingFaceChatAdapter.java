package kr.co.pawong.pwsb.infrastructure.ai.adapter.huggingface;

import static kr.co.pawong.pwsb.global.error.errorcode.CustomErrorCode.SEARCH_ERROR;
import static kr.co.pawong.pwsb.infrastructure.ai.enums.RefineMsg.REFINE_TEMPLATE_1;
import static kr.co.pawong.pwsb.infrastructure.ai.enums.TaggingMsg.TAGGING_TEMPLATE_1;

import java.util.List;
import kr.co.pawong.pwsb.global.error.exception.BaseException;
import kr.co.pawong.pwsb.infrastructure.ai.enums.AnimalFeature;
import kr.co.pawong.pwsb.infrastructure.ai.port.ChatProcessorPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("HUGGINGFACE_CHAT")
@RequiredArgsConstructor
public class HuggingFaceChatAdapter implements ChatProcessorPort {

    private final HuggingFaceChatModel chatModel;

    @Override
    public String queryByPrompt(String prompt) {
        return getCompletion(prompt);
    }

    @Override
    public String refineAdoptionSentence(String sentence) {
        String refinedStr = getCompletion(REFINE_TEMPLATE_1.getMessage(sentence));
        log.info("응답 문자열: {}", refinedStr);
        return refinedStr;
    }

    @Override
    public List<String> getTagsByFeature(String feature) {
        String tagsStr = getCompletion(TAGGING_TEMPLATE_1.getMessage(feature));
        log.info("응답 문자열: {}", tagsStr);
        return AnimalFeature.extractValidTags(tagsStr);
    }

    private String getCompletion(String sentence) {
        try {
            return chatModel.call(sentence);
        } catch (Exception e) {
            throw new BaseException(SEARCH_ERROR, e);
        }
    }
}
