package com.huvenet.practice.ddd.cargo.domain.event;

import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import com.huvenet.practice.ddd.cargo.infra.DeliverCargoPersistent;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.core.application.DomainResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliverCargoEvent implements ICargoEvent {

    private final DeliverCargoPersistent deliverCargoPersistent;

    @Override
    public DomainResult<CargoAggregate> someAction() {
        return null;
    }

    @Override
    public DomainResult<CargoAggregate> insertCargo(InsertCargoRequest request) {
        CargoAggregate insertCargoAggregate = deliverCargoPersistent.insertCargo(


            CargoAggregate.initByCargoUsingCapacity()
                .capacity(
                    Capacity.initByAll()
                        .length(request.getLength())
                        .weight(request.getWeight())
                        .build()).
                build());
        if(insertCargoAggregate.getRoot() != null) {
            return new DomainResult<>(true, insertCargoAggregate);
        }
        return new DomainResult<>(false);
    }
}
