package com.umc.study.converter;

import com.umc.study.domain.Member;
import com.umc.study.domain.enums.Gender;
import com.umc.study.dto.controller.member.MemberControllerRequest;
import com.umc.study.dto.service.member.MemberServiceRequest;
import com.umc.study.dto.service.member.MemberServiceResponse.JoinResultDto;

public class MemberConverter {

    public static JoinResultDto toMemberJoinResultResponseDto(final Member member) {
        return JoinResultDto.builder()
            .memberId(member.getId())
            .createdAt(member.getCreatedAt())
            .build();
    }

    public static MemberServiceRequest.JoinDto toMemberJoinServiceRequestDto(
        final MemberControllerRequest.JoinDto controllerRequestDto
    ) {
        return MemberServiceRequest.JoinDto.builder()
            .email(controllerRequestDto.email())
            .gender(controllerRequestDto.gender())
            .inactiveDate(controllerRequestDto.inactiveDate())
            .name(controllerRequestDto.name())
            .nickname(controllerRequestDto.nickname())
            .phone(controllerRequestDto.phone())
            .preferCategory(controllerRequestDto.preferCategory())
            .build();
    }

    public static Member toMember(final MemberServiceRequest.JoinDto joinDto) {
        return Member.builder()
            .email(joinDto.email())
            .gender(Gender.valueOf(joinDto.gender()))
            .inactiveDate(joinDto.inactiveDate())
            .name(joinDto.name())
            .nickname(joinDto.nickname())
            .phone(joinDto.phone())
            .build();
    }
}
