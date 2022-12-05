package com.huvenet.practice.ddd.core.domain;

import com.huvenet.practice.ddd.core.infra.BaseEntity;
import lombok.Getter;

@Getter
public class Aggregate<T extends DomainModel> {

    protected T root;

    protected Aggregate() {
    }

    protected Aggregate(T root) {
        this.root = root;
    }
}
