package com.huvenet.practice.ddd.core.domain;

public class Aggregate<T extends BaseEntity> {

    private T root;

    protected Aggregate() {
    }

    protected Aggregate(T root) {
        this.root = root;
    }
}
