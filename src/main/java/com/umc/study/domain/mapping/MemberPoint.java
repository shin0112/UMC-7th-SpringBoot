package com.umc.study.domain.mapping;

import com.umc.study.domain.Member;
import com.umc.study.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPoint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "INT(10) DEFAULT '0'")
    private int missionCount;

    @Column(nullable = false, columnDefinition = "INT DEFAULT '0'")
    private int point;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public MemberPoint(final Member member) {
        this.missionCount = 0;
        this.point = 0;
        this.member = member;
    }
}
