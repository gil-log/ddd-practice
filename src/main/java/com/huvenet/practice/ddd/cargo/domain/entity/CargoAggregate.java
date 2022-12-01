package com.huvenet.practice.ddd.cargo.domain.entity;

import com.huvenet.practice.ddd.cargo.domain.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.Aggregate;
import java.util.Date;
import lombok.Builder;

public class CargoAggregate extends Aggregate<Cargo> {

    @Builder(
        builderMethodName = "initEmpty"
    )
    private CargoAggregate() {
        super();
    }


    @Builder(
        builderMethodName = "initByRoot"
    )
    private CargoAggregate(Cargo cargo) {
        super(cargo);
    }

    @Builder(
        builderMethodName = "initByCargoUsingCapacity"
    )
    private CargoAggregate(Capacity capacity) {
        super(Cargo
            .initByCapacity()
            .capacity(capacity)
            .build()
        );
    }

    public Long getId() {
        return root.getId();
    }

    public Date getCreatedAt() {
        return root.getCreatedAt();
    }

    public Date getUpdatedAt() {
        return root.getUpdatedAt();
    }

    public Capacity getCapacity() {
        return root.getCapacity();
    }
}
