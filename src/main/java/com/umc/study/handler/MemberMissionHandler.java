package com.umc.study.handler;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.global.apiPayload.exception.GeneralException;

public class MemberMissionHandler extends GeneralException {

    public MemberMissionHandler(final ErrorStatus status) {
        super(status);
    }
}
