package com.umc.study.repository.store;

import com.umc.study.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);

}
