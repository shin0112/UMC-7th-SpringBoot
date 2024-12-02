package com.umc.study.service.store;

import com.umc.study.converter.StoreConverter;
import com.umc.study.domain.Region;
import com.umc.study.domain.Store;
import com.umc.study.dto.controller.StoreControllerRequest.CreateDto;
import com.umc.study.dto.service.store.StoreServiceResponse;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.handler.RegionHandler;
import com.umc.study.repository.store.RegionRepository;
import com.umc.study.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreServiceResponse.CreateDto createStore(
        final String regionName,
        final CreateDto request
    ) {
        Region region = regionRepository.findByName(regionName)
            .orElseThrow(() -> new RegionHandler(ErrorStatus._NOT_FOUND_REGION));

        Store store = storeRepository.save(new Store(
            request.name(),
            request.address(),
            region
        ));

        return StoreConverter.toStoreCreateDto(store);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isExistStore(final Long storeId) {
        return storeRepository.findById(storeId).isPresent();
    }
}
