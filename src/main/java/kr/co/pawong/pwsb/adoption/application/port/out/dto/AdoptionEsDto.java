package kr.co.pawong.pwsb.adoption.application.port.out.dto;

import java.util.List;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import kr.co.pawong.pwsb.adoption.enums.NeuterYn;
import kr.co.pawong.pwsb.adoption.enums.SexCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindCd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionEsDto {

    private Long adoptionId;
    private ActiveState activeState;
    private UpKindCd upKindCd;
    private SexCd sexCd;
    private NeuterYn neuterYn;
    private String city;
    private String district;
    private String refinedSpecialMark;
    private List<String> tagsField;
    private float[] embedding;

    public static AdoptionEsDto from(Adoption adoption, RegionInfoDto regionInfo) {
        List<String> tagsField = adoption.getTagsField() == null ? List.of()
                : List.of(adoption.getTagsField().split(","));

        return AdoptionEsDto.builder()
                .adoptionId(adoption.getAdoptionId())
                .activeState(adoption.getActiveState())
                .upKindCd(adoption.getUpKindCd())
                .sexCd(adoption.getSexCd())
                .neuterYn(adoption.getNeuterYn())
                .city(regionInfo.getCity())
                .district(regionInfo.getDistrict())
                .refinedSpecialMark(adoption.getRefinedSpecialMark())
                .tagsField(tagsField)
                .embedding(adoption.getEmbedding())
                .build();
    }
}
