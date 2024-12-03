package com.umc.study.handler;

import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.global.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {

    public FoodHandler(final ErrorStatus status) {
        super(status);
    }
}
