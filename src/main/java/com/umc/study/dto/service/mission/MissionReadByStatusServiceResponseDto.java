package com.umc.study.dto.service.mission;

import lombok.Builder;

@Builder
public record MissionReadByStatusServiceResponseDto(
    Long id,
    String name,
    int money,
    int point,
    String status
) {

}
