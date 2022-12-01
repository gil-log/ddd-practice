package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
import com.huvenet.practice.ddd.cargo.domain.vo.Capacity;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.core.application.DomainResult;
import org.springframework.stereotype.Service;

@Service
public class ReceiverCargoEvent implements ICargoEvent, ICargoVariousEvent {

    @Override
    public DomainResult<CargoAggregate> someAction() {
        return new DomainResult<>(false, null);
    }

    @Override
    public DomainResult<CargoAggregate> insertCargo(InsertCargoRequest request) {
        return null;
    }

    @Override
    public DomainResult<CargoAggregate> anotherVariousAction() {
        return new DomainResult<>(false, null);
    }
}
