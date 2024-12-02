package com.umc.study.converter;

import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.dto.controller.MissionControllerRequest;
import com.umc.study.dto.service.mission.MissionServiceRequest;
import com.umc.study.dto.service.mission.MissionServiceResponse.CreateDto;

public class MissionConverter {

    public static MissionServiceRequest.CreateDto toMissionCreateServiceRequestDto(
        MissionControllerRequest.CreateDto request
    ) {
        return MissionServiceRequest.CreateDto.builder()
            .storeId(request.storeId())
            .money(request.money())
            .point(request.point())
            .name(request.name())
            .build();
    }

    public static Mission toMission(Store store, MissionServiceRequest.CreateDto request) {
        return Mission.builder()
            .store(store)
            .money(request.money())
            .point(request.point())
            .name(request.name())
            .build();
    }

    public static CreateDto toMissionCreateResponseDto(final Mission mission) {
        return new CreateDto(mission.getId());
    }

    public static CreateDto toMissionCreateResponseDto(final MemberMission memberMission) {
        return new CreateDto(memberMission.getId());
    }
}
