package com.umc.study.handler;

import com.umc.study.global.apiPayload.code.BaseCode;
import com.umc.study.global.apiPayload.code.status.ErrorStatus;
import com.umc.study.global.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(final ErrorStatus status) {
        super(status);
    }
}
