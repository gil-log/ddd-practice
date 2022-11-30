package com.huvenet.practice.ddd.cargo.domain.entity;

import com.huvenet.practice.ddd.cargo.domain.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.Aggregate;
import lombok.Builder;

public class CargoAggregate extends Aggregate<Cargo> {

    private CargoAggregate() {
        super();
    }

    @Builder(
        builderClassName = "initCargo"
        , builderMethodName = "initCargoByCapacity"
    )
    private CargoAggregate(Capacity capacity) {
        super(Cargo
            .initByCapacity()
            .capacity(capacity)
            .build()
        );
    }
}
