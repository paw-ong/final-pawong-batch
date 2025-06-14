package kr.co.pawong.pwsb.infrastructure.api.dto;

import java.time.LocalDate;
import kr.co.pawong.pwsb.shelter.adapter.out.persistence.jpa.entity.ShelterEntity;
import kr.co.pawong.pwsb.shelter.enums.DivisionNm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShelterCreate {
    private Long shelterId;
    private String careNm; // 동물보호센터명
    private String careRegNo; // 보호소 번호
    private String orgNm; // 관리 기관명
    private DivisionNm divisionNm; // 동물보호센터 유형 - (ENUM)
    private String saveTrgtAnimal; // 구조대상동물
    private String careAddr; // 소재지 도로명 주소
    private String jibunAddr; // 소재지번주소
    private String city; // 시도
    private String district; // 시군구
    private Double lat; // 위도(double)
    private Double lng; // 경도(double)
    private LocalDate dsignationDate; // 동물보호센터 지정일자
    private String weekOprStime; // 평일 운영시작 시간
    private String weekOprEtime; // 평일 운영종료 시간
    private String weekCellStime; // 평일 분양시작 시간
    private String weekCellEtime; // 평일 분양종료 시간
    private String weekendOprStime; // 주말 운영시작 시간
    private String weekendOprEtime; // 주말 운영종료 시간
    private String weekendCellStime; // 주말 분양시작 시간
    private String weekendCellEtime; // 주말 분양종료 시간
    private String closeDay; // 휴무일
    private Integer vetPersonCnt; // 수의사 인원수
    private Integer specsPersonCnt; // 사양관리사 인원수
    private Integer medicalCnt; // 진료실 수
    private Integer breedCnt; // 사육실 수
    private Integer quarabtineCnt; // 격리실 수
    private Integer feedCnt; // 사료보관실 수
    private Integer transCarCnt; // 구조운반용차량보유대 수
    private String careTel; // 전화번호
    private LocalDate dataStdDt; // 데이터 기준일자

    // 동물보호소 중복 확인
    public ShelterEntity toEntity() {
        ShelterEntity shelterEntity = ShelterEntity.builder()
                .shelterId(this.shelterId)
                .careNm(this.careNm)
                .careRegNo(this.careRegNo)
                .orgNm(this.orgNm)
                .divisionNm(this.divisionNm)
                .saveTrgtAnimal(this.saveTrgtAnimal)
                .careAddr(this.careAddr)
                .jibunAddr(this.jibunAddr)
                .city(this.city)
                .district(this.district)
                .lat(this.lat)
                .lng(this.lng)
                .dsignationDate(this.dsignationDate)
                .weekOprStime(this.weekOprStime)
                .weekOprEtime(this.weekOprEtime)
                .weekCellStime(this.weekCellStime)
                .weekCellEtime(this.weekCellEtime)
                .weekendOprStime(this.weekendOprStime)
                .weekendOprEtime(this.weekendOprEtime)
                .weekendCellStime(this.weekendCellStime)
                .weekendCellEtime(this.weekendCellEtime)
                .closeDay(this.closeDay)
                .vetPersonCnt(this.vetPersonCnt)
                .specsPersonCnt(this.specsPersonCnt)
                .medicalCnt(this.medicalCnt)
                .breedCnt(this.breedCnt)
                .quarabtineCnt(this.quarabtineCnt)
                .feedCnt(this.feedCnt)
                .transCarCnt(this.transCarCnt)
                .careTel(this.careTel)
                .dataStdDt(this.dataStdDt)
                .build();

        return shelterEntity;
    }
}
