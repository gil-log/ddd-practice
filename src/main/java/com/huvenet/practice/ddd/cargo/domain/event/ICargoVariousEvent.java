package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import com.huvenet.practice.ddd.core.application.DomainResult;

public interface ICargoVariousEvent {

    DomainResult<CargoAggregate> anotherVariousAction();
}
