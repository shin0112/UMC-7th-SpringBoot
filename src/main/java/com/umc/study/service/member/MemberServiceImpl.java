package com.umc.study.service.member;

import com.umc.study.converter.MemberConverter;
import com.umc.study.domain.Food;
import com.umc.study.domain.Member;
import com.umc.study.domain.mapping.MemberFood;
import com.umc.study.dto.service.member.MemberServiceRequest.JoinDto;
import com.umc.study.dto.service.member.MemberServiceResponse.JoinResultDto;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.handler.FoodHandler;
import com.umc.study.repository.food.FoodRepository;
import com.umc.study.repository.member.MemberFoodRepository;
import com.umc.study.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;
    private final FoodRepository foodRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public JoinResultDto join(final JoinDto request) {
        Member member = memberRepository.save(MemberConverter.toMember(request));
        member.encodePassword(passwordEncoder.encode(request.password()));

        request.preferCategory().forEach(category -> {
            Food food = foodRepository.findById(category)
                .orElseThrow(() -> new FoodHandler(ErrorStatus._NOT_FOUND_FOOD));
            memberFoodRepository.save(new MemberFood(member, food));
        });

        return MemberConverter.toMemberJoinResultResponseDto(member);
    }
}
