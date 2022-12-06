package com.huvenet.practice.ddd.cargo.domain.model;

import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.DomainModel;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Cargo extends DomainModel {

    // Domain : 하나의 Cargo는 Capacity를 가져야 한다.
    private Capacity capacity;

    private Object testReceiver;
    private Object testSender;
    private Object testCategory;

    private Cargo() {
    }

    @Builder(
        builderMethodName = "initByCapacity"
    )
    private Cargo(Capacity capacity) {
        this.capacity = capacity;
    }

    @Builder(
        builderMethodName = "initByCapacityAndBase"
    )
    private Cargo(Capacity capacity, Long id, Date createdAt, Date updatedAt) {
        validateCapacityNonNull(capacity);
        this.capacity = capacity;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void validateCapacityNonNull(Capacity capacity) {
        if(capacity == null) throw new NullPointerException();
    }
}
