package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
import com.huvenet.practice.ddd.core.application.DomainResult;
import org.springframework.stereotype.Service;

@Service
public class DeliverCargoEvent implements ICargoEvent {

    @Override
    public DomainResult<CargoAggregate> someAction() {
        return null;
    }
}
