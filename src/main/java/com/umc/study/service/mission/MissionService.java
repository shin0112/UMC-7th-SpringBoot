package com.umc.study.service.mission;

import com.umc.study.dto.service.mission.MissionReadByStatusServiceResponseDto;
import com.umc.study.dto.service.mission.MissionServiceRequest;
import com.umc.study.dto.service.mission.MissionServiceResponse.CreateDto;
import java.util.List;

public interface MissionService {

    List<MissionReadByStatusServiceResponseDto> getMissionListByStatus(
        Long memberId,
        String status
    );

    CreateDto createMission(MissionServiceRequest.CreateDto request);
}
