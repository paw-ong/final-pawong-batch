package kr.co.pawong.pwsb.batch.writer;

import java.util.ArrayList;
import java.util.List;
import kr.co.pawong.pwsb.adoption.application.port.in.CommandAdoptionEngineUseCase;
import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionEsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdoptionEsWriter implements ItemWriter<AdoptionEsDto> {
    private final CommandAdoptionEngineUseCase commandAdoptionEngineUseCase;

    @Override
    public void write(Chunk<? extends AdoptionEsDto> chunk) {
        List<AdoptionEsDto> items = new ArrayList<>(chunk.getItems());
        // ES에 저장 + 임베딩 여부 업데이트
        commandAdoptionEngineUseCase.saveEsAndUpdateIsEmbedded(items);
    }
}
