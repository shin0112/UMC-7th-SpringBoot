package com.umc.study.repository.mission;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.enums.MissionStatus;
import com.umc.study.domain.mapping.MemberMission;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    List<MemberMission> findByMemberAndStatus(Member member, MissionStatus status);
    List<MemberMission> findByMember(Member member);

    @Query("SELECT m "
        + "FROM MemberMission m "
        + "WHERE m.member = :member AND m.mission = :mission "
        + "ORDER BY m.updatedAt DESC")
    Optional<MemberMission> findTop1ByMemberAndMission(
        @Param("member") Member member,
        @Param("mission") Mission mission
    );
}
