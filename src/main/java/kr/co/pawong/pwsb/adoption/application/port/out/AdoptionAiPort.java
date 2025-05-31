package kr.co.pawong.pwsb.adoption.application.port.out;

import java.util.List;

public interface AdoptionAiPort {

    // 문장 정제하는 함수
    String refineSpecialMark(String specialMark);

    // 입력된 문장에 대해 태그를 선택해서 문자열 리스트로 반환하는 함수
    List<String> tag(String feature);

    // 문장 임베딩하는 함수
    float[] embed(String completion);

}