package com.huvenet.practice.ddd.cargo.domain.entity;

import com.huvenet.practice.ddd.cargo.domain.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.BaseEntity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Builder;

@Entity
public class Cargo extends BaseEntity {

    @Embedded
    private Capacity capacity;

    protected Cargo() {
    }

    @Builder(
        builderClassName = "init"
        , builderMethodName = "initByCapacity"
    )
    protected Cargo(Capacity capacity) {
        this.capacity = capacity;
    }

}
