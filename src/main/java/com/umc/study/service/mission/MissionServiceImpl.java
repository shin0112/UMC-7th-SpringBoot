package com.umc.study.service.mission;

import com.umc.study.converter.MemberMissionConverter;
import com.umc.study.converter.MissionConverter;
import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.Store;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.dto.service.mission.MissionReadByStatusServiceResponseDto;
import com.umc.study.dto.service.mission.MissionServiceRequest;
import com.umc.study.dto.service.mission.MissionServiceResponse.CreateDto;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.handler.MissionHandler;
import com.umc.study.handler.StoreHandler;
import com.umc.study.repository.member.MemberRepository;
import com.umc.study.repository.mission.MemberMissionRepository;
import com.umc.study.repository.mission.MissionRepository;
import com.umc.study.repository.store.StoreRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
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
        MissionStatus missionStatus;

        try {
            missionStatus = MissionStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new MissionHandler(ErrorStatus._NOT_FOUND_MISSION_STATUS);
        }

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

    @Override
    public CreateDto createMission(@Valid final MissionServiceRequest.CreateDto request) {
        Store store = storeRepository.findById(request.storeId())
            .orElseThrow(() -> new StoreHandler(ErrorStatus._NOT_FOUND_STORE));

        Mission mission = missionRepository.save(MissionConverter.toMission(store, request));

        return MissionConverter.toMissionCreateResponseDto(mission);
    }
}
