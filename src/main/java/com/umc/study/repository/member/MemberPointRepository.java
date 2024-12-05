package com.umc.study.repository.member;

import com.umc.study.domain.Member;
import com.umc.study.domain.mapping.MemberPoint;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPointRepository extends JpaRepository<MemberPoint, Long> {

    Optional<MemberPoint> findByMember(Member member);
}
