package com.huvenet.practice.ddd.cargo.domain.model;

import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.DomainModel;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Cargo extends DomainModel {

    private Capacity capacity;

    private Cargo() {
    }

    @Builder(
        builderMethodName = "initByCapacity"
    )
    private Cargo(Capacity capacity) {
        this.capacity = capacity;
    }

    @Builder(
        builderMethodName = "initByAll"
    )
    private Cargo(Capacity capacity, Long id, Date createdAt, Date updatedAt) {
        this.capacity = capacity;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
