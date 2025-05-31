package kr.co.pawong.pwsb.infrastructure.ai.adapter.openai;

import static kr.co.pawong.pwsb.global.error.errorcode.CustomErrorCode.SEARCH_ERROR;

import kr.co.pawong.pwsb.global.error.exception.BaseException;
import kr.co.pawong.pwsb.infrastructure.ai.port.EmbeddingProcessorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 문장에서 특징을 추출(임베딩)하는 기능을 제공합니다.
 */
@Component
@Qualifier("OPENAI_EMBEDDING")
@RequiredArgsConstructor
public class OpenAiEmbeddingAdapter implements EmbeddingProcessorPort {

    private final OpenAiEmbeddingModel embeddingModel;

    @Override
    public float[] embed(String completion) {
        return getEmbedding(completion);
    }

    private float[] getEmbedding(String completion) {
        try {
            return embeddingModel.embed(completion);
        } catch (Exception e) {
            throw new BaseException(SEARCH_ERROR, e);
        }
    }
}
