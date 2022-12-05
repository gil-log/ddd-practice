package com.huvenet.practice.ddd.core.application;

import com.huvenet.practice.ddd.core.domain.Aggregate;
import lombok.Getter;

@Getter
public class DomainResult<T extends Aggregate<?>> {
    private boolean success;
    private String message;
    private T result;

    private DomainResult() {
    }

    public DomainResult(boolean success) {
        this.success = success;
    }

    public DomainResult(boolean success, T result) {
        this.success = success;
        this.result = result;
    }
}
