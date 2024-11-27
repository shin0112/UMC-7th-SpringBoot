package com.umc.study.service.mission;

import com.umc.study.converter.MemberMissionConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.dto.service.mission.MissionReadByStatusServiceResponseDto;
import com.umc.study.repository.member.MemberRepository;
import com.umc.study.repository.mission.MemberMissionRepository;
import com.umc.study.repository.mission.MissionRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));
    }

    @Override
    public List<MissionReadByStatusServiceResponseDto> getMissionListByStatus(
        final Long memberId,
        final String status
    ) {
        Member member = findMemberById(memberId);
        MissionStatus missionStatus = MissionStatus.valueOf(status);


        return memberMissionRepository.findByMemberAndStatus(
                member,
                missionStatus
            )
            .stream()
            .map(memberMission -> {
                System.out.println(
                    "미션: " + MemberMissionConverter.toMissionReadByStatusServiceResponseDto(
                        memberMission));
                return MemberMissionConverter.toMissionReadByStatusServiceResponseDto(
                    memberMission);
            })
            .collect(Collectors.toList());
    }
}
