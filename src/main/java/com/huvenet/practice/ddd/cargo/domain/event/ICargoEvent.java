package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.core.application.DomainResult;

public interface ICargoEvent {
    DomainResult<CargoAggregate> someAction();

    DomainResult<CargoAggregate> insertCargo(InsertCargoRequest request);
}
