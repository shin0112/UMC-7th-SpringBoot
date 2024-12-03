package com.umc.study.validation.annotation;

import com.umc.study.validation.validator.CategoryExistValidator;
import com.umc.study.validation.validator.MissionChallengeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Constraint(validatedBy = MissionChallengeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAlreadyChallenging {

    String message() default "이미 도전 중인 미션 입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
