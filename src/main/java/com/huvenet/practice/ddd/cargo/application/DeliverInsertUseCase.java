package com.huvenet.practice.ddd.cargo.application;

import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import com.huvenet.practice.ddd.cargo.domain.event.DeliverCargoEvent;
import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.response.InsertCargoResponse;
import com.huvenet.practice.ddd.cargo.presentation.response.InsertCargoResponse.ResponseCode;
import com.huvenet.practice.ddd.core.application.BaseUseCase;
import com.huvenet.practice.ddd.core.application.DomainResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliverInsertUseCase extends BaseUseCase<InsertCargoRequest, InsertCargoResponse> {

    private final DeliverCargoEvent deliverCargoEvent;

    @Override
    public InsertCargoResponse execute(InsertCargoRequest request) {
        DomainResult<CargoAggregate> insertCargoEventResult = deliverCargoEvent.insertCargo(request);
        if(insertCargoEventResult.isSuccess()) {
            CargoAggregate resultCargoAggregate = insertCargoEventResult.getResult();
            Capacity resultCargoCapacity = resultCargoAggregate.getCapacity();
            return InsertCargoResponse.initBody()
                .id(resultCargoAggregate.getId())
                .length(resultCargoCapacity.getLength())
                .weight(resultCargoCapacity.getWeight())
                .createdAt(resultCargoAggregate.getCreatedAt())
                .updatedAt(resultCargoAggregate.getUpdatedAt())
                .build();
        } else {
            return InsertCargoResponse.initFail().code(ResponseCode.HUK_WHY).build();
        }
    }
}
