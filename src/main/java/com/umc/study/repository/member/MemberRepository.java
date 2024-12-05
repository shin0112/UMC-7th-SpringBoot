package com.umc.study.repository.member;

import com.umc.study.domain.Member;
import com.umc.study.domain.enums.MemberStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.name = :name and m.status = :status")
    List<Member> findByNameAndStatus(
        @Param("name") String name,
        @Param("status") MemberStatus status
    );

    Optional<Member> findByEmail(final String email);
}
