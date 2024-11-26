package com.umc.study.converter;

import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.dto.service.MissionReadByStatusServiceResponseDto;

public class MemberMissionConverter {

    public static MissionReadByStatusServiceResponseDto toMissionReadByStatusServiceResponseDto(
        MemberMission memberMission) {

        return MissionReadByStatusServiceResponseDto.builder()
            .id(memberMission.getMission().getId())
            .name(memberMission.getMission().getName())
            .money(memberMission.getMission().getMoney())
            .point(memberMission.getMission().getPoint())
            .status(memberMission.getStatus().toString())
            .build();
    }
}
