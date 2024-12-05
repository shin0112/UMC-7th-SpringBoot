package com.umc.study.validation.validator;

import com.umc.study.dto.controller.MissionControllerRequest;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.service.mission.MissionService;
import com.umc.study.validation.annotation.CheckAlreadyChallenging;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements
    ConstraintValidator<CheckAlreadyChallenging, MissionControllerRequest.ChallengeDto> {

    private final MissionService missionService;

    @Override
    public void initialize(final CheckAlreadyChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(
        final MissionControllerRequest.ChallengeDto request,
        final ConstraintValidatorContext context
    ) {
        boolean isValid = missionService.isChallengingMission(
            request.memberId(),
            request.missionId()
        );

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                ErrorStatus._ALREADY_CHALLENGING_MISSION.toString()
            ).addConstraintViolation();
        }

        return isValid;
    }
}
