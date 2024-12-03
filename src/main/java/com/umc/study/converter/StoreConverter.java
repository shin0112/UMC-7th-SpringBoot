package com.umc.study.converter;

import com.umc.study.domain.Store;
import com.umc.study.dto.service.store.StoreServiceResponse.CreateDto;

public class StoreConverter {

    public static CreateDto toStoreCreateDto(Store store) {
        return CreateDto.builder()
            .name(store.getName())
            .address(store.getAddress())
            .build();
    }
}
