package com.umc.study.service.store;

import com.umc.study.domain.Store;
import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoreListByNameAndScore(String name, Float score);

}
