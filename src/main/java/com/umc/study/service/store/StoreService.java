package com.umc.study.service.store;

import com.umc.study.dto.controller.StoreControllerRequest.CreateDto;
import com.umc.study.dto.service.store.StoreServiceResponse;

public interface StoreService {

    StoreServiceResponse.CreateDto createStore(String region, CreateDto request);

    Boolean isExistStore(Long storeId);
}
