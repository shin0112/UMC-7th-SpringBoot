package com.umc.study.service.store;

import com.umc.study.domain.Store;
import com.umc.study.repository.store.StoreRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(final Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoreListByNameAndScore(final String name, final Float score) {
        List<Store> filteredStoreList = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        filteredStoreList.forEach(store -> System.out.println("store: " + store));
        return filteredStoreList;
    }
}
