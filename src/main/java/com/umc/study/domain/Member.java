package com.umc.study.domain;

import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.enums.Gender;
import com.umc.study.domain.enums.MemberStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'NO_GENDER'")
    private Gender gender;

    private LocalDate inactiveDate;

    @Column(unique = true, columnDefinition = "VARCHAR(25)")
    private String email;

    @Column(columnDefinition = "VARCHAR(11)")
    private String phone;

    @Column(nullable = true)
    private String photoLink;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, columnDefinition = "VARCHAR(15) DEFAULT 'INACTIVE'")
    private MemberStatus is_deleted;

    @Builder
    public Member(
        final String name,
        final String nickname,
        final Gender gender,
        final LocalDate inactiveDate,
        final String email,
        final String phone
    ) {
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.inactiveDate = inactiveDate;
        this.email = email;
        this.phone = phone;
    }
}
