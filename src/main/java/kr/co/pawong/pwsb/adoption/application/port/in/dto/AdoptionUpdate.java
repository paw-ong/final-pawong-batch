package kr.co.pawong.pwsb.adoption.application.port.in.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import kr.co.pawong.pwsb.adoption.enums.NeuterYn;
import kr.co.pawong.pwsb.adoption.enums.ProcessState;
import kr.co.pawong.pwsb.adoption.enums.SexCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindNm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionUpdate {
    private Long adoptionId; // 입양id
    private String desertionNo; // 구조번호
    private LocalDate happenDt; // 접수일
    private String happenPlace; // 발견장소
    private UpKindNm upKindNm; // 축종명
    private UpKindCd upKindCd; // 축종코드
    private String kindNm; // 품종명
    private String kindCd; // 품종코드
    private String colorCd; // 색상
    private Integer age; // 나이 - Long
    private String weight; // 체중
    private String noticeNo; // 공고번호
    private LocalDate noticeSdt; // 공고시작일
    private LocalDate noticeEdt; // 공고종료일
    private String popfile1; // 이미지1(텍스트)
    private String popfile2; // 이미지2(텍스트)
    private ProcessState processState; // 상태
    private ActiveState activeState;
    private SexCd sexCd; // 성별
    private NeuterYn neuterYn; // 중성화여부(타입)
    private String specialMark; // 특징
    private String careRegNo; // 보호소 번호
    private LocalDateTime updTm; // 수정일
}
