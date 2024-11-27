package com.umc.study.controller;

import com.umc.study.converter.MemberConverter;
import com.umc.study.dto.controller.member.MemberControllerRequest.JoinDto;
import com.umc.study.dto.service.member.MemberServiceResponse.JoinResultDto;
import com.umc.study.global.apiPayload.ApiResponse;
import com.umc.study.service.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ApiResponse<JoinResultDto> join(@RequestBody @Valid final JoinDto request) {
        return ApiResponse.success(
            memberService.join(MemberConverter.toMemberJoinServiceRequestDto(request))
        );
    }

}
