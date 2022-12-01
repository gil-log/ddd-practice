package com.huvenet.practice.ddd.core.domain;

import lombok.Getter;

@Getter
public class Aggregate<T extends BaseEntity> {

    protected T root;

    protected Aggregate() {
    }

    protected Aggregate(T root) {
        this.root = root;
    }
}
