package com.umc.study.service.mission;

import com.umc.study.dto.service.MissionReadByStatusServiceResponseDto;
import java.util.List;

public interface MissionService {

    List<MissionReadByStatusServiceResponseDto> getMissionListByStatus(
        Long memberId,
        String status
    );
}
