package com.umc.study.global.security;

import com.umc.study.domain.Member;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.handler.MemberHandler;
import com.umc.study.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
            .orElseThrow(() -> new MemberHandler(ErrorStatus._NOT_FOUND_MEMBER));

        return User
            .withUsername(member.getEmail())
            .password(member.getPassword())
            .roles(member.getRole().name())
            .build();
    }
}
