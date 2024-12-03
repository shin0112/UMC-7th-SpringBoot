package com.umc.study.handler;

import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.global.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(final ErrorStatus status) {
        super(status);
    }
}
