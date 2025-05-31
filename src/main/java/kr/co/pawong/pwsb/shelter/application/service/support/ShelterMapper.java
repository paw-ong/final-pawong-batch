package kr.co.pawong.pwsb.shelter.application.service.support;


import static kr.co.pawong.pwsb.global.utils.ApiDataUtils.parseAddress;

import kr.co.pawong.pwsb.adoption.application.port.out.dto.AdoptionCareDto;
import kr.co.pawong.pwsb.shelter.domain.Shelter;

public class ShelterMapper {

    public static Shelter fromAdoption(AdoptionCareDto adoptionCareDto) {
        // 주소 파싱
        String[] addressParts = parseAddress(adoptionCareDto.getCareAddr());
        String city = addressParts[0];
        String district = addressParts[1];

        return Shelter.builder()
                .careRegNo(adoptionCareDto.getCareRegNo())
                .careNm(adoptionCareDto.getCareNm())
                .careTel(adoptionCareDto.getCareTel())
                .careAddr(adoptionCareDto.getCareAddr())
                .orgNm(adoptionCareDto.getOrgNm())
                .city(city)          // 파싱된 도시 정보 추가
                .district(district)  // 파싱된 지역구 정보 추가
                .build();
    }
}
