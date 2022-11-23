package com.huvenet.practice.ddd.core.domain;

import lombok.Builder;

public class Aggregate<T extends BaseEntity> {

    private T root;

    private Aggregate() {
    }

    @Builder(
        builderClassName = "init"
        , builderMethodName = "initByRoot"
    )
    private Aggregate(T root) {
        this.root = root;
    }
}
