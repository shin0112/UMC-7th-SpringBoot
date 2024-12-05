package com.umc.study.validation.validator;

import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.service.store.StoreService;
import com.umc.study.validation.annotation.ExistStore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreService storeService;

    @Override
    public void initialize(final ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(
        final Long id,
        final ConstraintValidatorContext context
    ) {
        boolean isValid = storeService.isExistStore(id);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                .buildConstraintViolationWithTemplate(ErrorStatus._NOT_FOUND_STORE.toString())
                .addConstraintViolation();
        }

        return isValid;
    }
}
