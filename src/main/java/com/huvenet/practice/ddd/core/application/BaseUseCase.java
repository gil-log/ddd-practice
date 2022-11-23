package com.huvenet.practice.ddd.core.application;

import com.huvenet.practice.ddd.core.presentation.BaseRequest;
import com.huvenet.practice.ddd.core.presentation.BaseResponse;

public abstract class BaseUseCase<T extends BaseRequest, V extends BaseResponse> {

    public abstract V execute(T request);
}
