package com.umc.study.validation.validator;

import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.repository.food.FoodRepository;
import com.umc.study.validation.annotation.ExistCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryExistValidator implements ConstraintValidator<ExistCategory, List<Long>> {

    private final FoodRepository foodRepository;

    @Override
    public void initialize(final ExistCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(
        final List<Long> valueList,
        final ConstraintValidatorContext context
    ) {
        boolean isValid = valueList.stream()
            .allMatch(foodRepository::existsById);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                .buildConstraintViolationWithTemplate(ErrorStatus._NOT_FOUND_FOOD.toString())
                .addConstraintViolation();
        }

        return isValid;
    }
}
