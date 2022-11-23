package com.huvenet.practice.ddd.core.application;

import com.huvenet.practice.ddd.core.domain.Aggregate;
import lombok.Getter;

@Getter
public abstract class DomainResult<T extends Aggregate<?>> {
    private boolean success;
    private String message;
    private T result;

    public abstract Object transferResult();
}
