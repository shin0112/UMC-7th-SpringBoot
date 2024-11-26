package com.umc.study.repository.mission;

import com.umc.study.domain.Member;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.mapping.MemberMission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    List<MemberMission> findByMemberAndStatus(Member member, MissionStatus status);
    List<MemberMission> findByMember(Member member);

}
