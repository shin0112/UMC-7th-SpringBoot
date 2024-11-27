package com.umc.study.handler;

import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.global.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(ErrorStatus status) {
        super(status);
    }
}
