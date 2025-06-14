package kr.co.pawong.pwsb.adoption.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import kr.co.pawong.pwsb.adoption.domain.model.Adoption;
import kr.co.pawong.pwsb.adoption.enums.ActiveState;
import kr.co.pawong.pwsb.adoption.enums.NeuterYn;
import kr.co.pawong.pwsb.adoption.enums.ProcessState;
import kr.co.pawong.pwsb.adoption.enums.SexCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindNm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor
@Table(name = "Adoption")
public class AdoptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adoptionId; // 입양id

    @Column(unique = true)
    private String desertionNo; // 구조번호

    private LocalDate happenDt; // 접수일

    private String happenPlace; // 발견장소

    @Enumerated(EnumType.STRING)
    private UpKindNm upKindNm; // 축종명

    @Enumerated(EnumType.STRING)
    private UpKindCd upKindCd; // 축종코드

    private String kindNm; // 품종명

    private String kindCd; // 품종코드

    private String colorCd; // 색상

    private Integer age; // 나이 - Long

    private String weight; // 체중

    private String noticeNo; // 공고번호

    private LocalDate noticeSdt; // 공고시작일

    private LocalDate noticeEdt; // 공고종료일

    @Column(columnDefinition = "TEXT")
    private String popfile1; // 이미지1(텍스트)

    @Column(columnDefinition = "TEXT")
    private String popfile2; // 이미지2(텍스트)

    @Enumerated(EnumType.STRING)
    private ProcessState processState; // 상태

    @Enumerated(EnumType.STRING)
    private ActiveState activeState;

    @Enumerated(EnumType.STRING)
    private SexCd sexCd; // 성별

    @Enumerated(EnumType.STRING)
    private NeuterYn neuterYn; // 중성화여부(타입)

    private String specialMark; // 특징

    private String careRegNo; // 보호소 번호

    private LocalDateTime updTm; // 수정일

    private String refinedSpecialMark; // 데이터 정제

    private String tagsField; // 태깅

    @Column(nullable = false)
    private boolean isAiProcessed;

    @Column(nullable = false)
    private boolean isEmbedded;

    // Adoption -> AdoptionEntity
    public static AdoptionEntity from(Adoption adoption) {
        AdoptionEntity entity = new AdoptionEntity();

        entity.adoptionId = adoption.getAdoptionId();
        entity.desertionNo = adoption.getDesertionNo();
        entity.happenDt = adoption.getHappenDt();
        entity.happenPlace = adoption.getHappenPlace();
        entity.upKindNm = adoption.getUpKindNm();
        entity.upKindCd = adoption.getUpKindCd();
        entity.kindNm = adoption.getKindNm();
        entity.kindCd = adoption.getKindCd();
        entity.colorCd = adoption.getColorCd();
        entity.age = adoption.getAge();
        entity.weight = adoption.getWeight();
        entity.noticeNo = adoption.getNoticeNo();
        entity.noticeSdt = adoption.getNoticeSdt();
        entity.noticeEdt = adoption.getNoticeEdt();
        entity.popfile1 = adoption.getPopfile1();
        entity.popfile2 = adoption.getPopfile2();
        entity.processState = adoption.getProcessState();
        entity.activeState = adoption.getActiveState();
        entity.sexCd = adoption.getSexCd();
        entity.neuterYn = adoption.getNeuterYn();
        entity.specialMark = adoption.getSpecialMark();
        entity.careRegNo = adoption.getCareRegNo();
        entity.updTm = adoption.getUpdTm();
        entity.refinedSpecialMark = adoption.getRefinedSpecialMark();
        entity.tagsField = adoption.getTagsField();
        entity.isAiProcessed = adoption.isAiProcessed();
        entity.isEmbedded = adoption.isEmbedded();

        return entity;
    }

    // AdoptionEntity -> Adoption
    public Adoption toModel() {
        return Adoption.builder()
                .adoptionId(this.adoptionId)
                .desertionNo(this.desertionNo)
                .happenDt(this.happenDt)
                .happenPlace(this.happenPlace)
                .upKindCd(this.upKindCd)
                .upKindNm(this.upKindNm)
                .kindCd(this.kindCd)
                .kindNm(this.kindNm)
                .colorCd(this.colorCd)
                .age(this.age)
                .weight(this.weight)
                .noticeNo(this.noticeNo)
                .noticeSdt(this.noticeSdt)
                .noticeEdt(this.noticeEdt)
                .popfile1(this.popfile1)
                .popfile2(this.popfile2)
                .processState(this.processState)
                .activeState(this.activeState)
                .sexCd(this.sexCd)
                .neuterYn(this.neuterYn)
                .specialMark(this.specialMark)
                .careRegNo(this.careRegNo)
                .updTm(this.updTm)
                .refinedSpecialMark(this.refinedSpecialMark)
                .tagsField(this.tagsField)
                .isAiProcessed(this.isAiProcessed)
                .isEmbedded(this.isEmbedded)
                .build();
    }

    // 업데이트 메서드
    public void update(Adoption adoption) {
        this.happenDt = adoption.getHappenDt();
        this.happenPlace = adoption.getHappenPlace();
        this.upKindNm = adoption.getUpKindNm();
        this.upKindCd = adoption.getUpKindCd();
        this.kindNm = adoption.getKindNm();
        this.kindCd = adoption.getKindCd();
        this.colorCd = adoption.getColorCd();
        this.age = adoption.getAge();
        this.weight = adoption.getWeight();
        this.noticeNo = adoption.getNoticeNo();
        this.noticeSdt = adoption.getNoticeSdt();
        this.noticeEdt = adoption.getNoticeEdt();
        this.popfile1 = adoption.getPopfile1();
        this.popfile2 = adoption.getPopfile2();
        this.processState = adoption.getProcessState();
        this.activeState = adoption.getActiveState();
        this.sexCd = adoption.getSexCd();
        this.neuterYn = adoption.getNeuterYn();
        this.specialMark = adoption.getSpecialMark();
        this.careRegNo = adoption.getCareRegNo();
        this.updTm = adoption.getUpdTm();

        // Ai 정제, 임베딩 필드 초기화
        this.refinedSpecialMark = null;
        this.tagsField = null;
        this.isAiProcessed = false;
        this.isEmbedded = false;
    }
}