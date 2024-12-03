package com.umc.study.service.member;

import com.umc.study.dto.service.member.MemberServiceRequest;
import com.umc.study.dto.service.member.MemberServiceResponse.JoinResultDto;

public interface MemberService {

    public JoinResultDto join(final MemberServiceRequest.JoinDto request);
}
