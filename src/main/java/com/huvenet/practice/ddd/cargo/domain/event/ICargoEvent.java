package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.entity.Cargo;
import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.core.application.DomainResult;

public interface ICargoEvent {
    public DomainResult<CargoAggregate> someAction();

    public DomainResult<CargoAggregate> insertCargo(InsertCargoRequest request);
}
