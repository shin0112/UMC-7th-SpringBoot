package com.umc.study.service.food;

import com.umc.study.repository.food.FoodRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    @Transactional(readOnly = true)
    public Boolean isExistFood(final List<Long> foodIdList) {
        return foodIdList.stream()
            .allMatch(foodRepository::existsById);
    }
}
