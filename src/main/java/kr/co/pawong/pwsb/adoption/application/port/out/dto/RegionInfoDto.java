package kr.co.pawong.pwsb.adoption.application.port.out.dto;

import kr.co.pawong.pwsb.shelter.application.port.in.dto.ShelterInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionInfoDto {
    private String city;
    private String district;

    public static RegionInfoDto from(ShelterInfoDto shelterInfoDto) {
        return RegionInfoDto.builder()
                .city(shelterInfoDto.getCity())
                .district(shelterInfoDto.getDistrict())
                .build();
    }

}
