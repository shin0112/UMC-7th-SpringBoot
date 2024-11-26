package com.umc.study.controller;

import com.umc.study.dto.service.MissionReadByStatusServiceResponseDto;
import com.umc.study.service.mission.MissionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/mine/{memberId}")
    public List<MissionReadByStatusServiceResponseDto> getMissionListByStatus(
        @PathVariable(name = "memberId") final Long memberId,
        @RequestParam(name = "status") final String status
    ) {
        return missionService.getMissionListByStatus(memberId, status);
    }
}
