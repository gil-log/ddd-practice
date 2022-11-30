package com.huvenet.practice.ddd.cargo.application;

import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
import com.huvenet.practice.ddd.cargo.domain.event.DeliverCargoEvent;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.response.FindCargoResponse;
import com.huvenet.practice.ddd.core.application.BaseUseCase;
import com.huvenet.practice.ddd.core.application.DomainResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliverAUseCase extends BaseUseCase<FindCargoRequest, FindCargoResponse> {

    private final DeliverCargoEvent deliverCargoEvent;

    @Override
    public FindCargoResponse execute(FindCargoRequest request) {
        DomainResult<CargoAggregate> someActionResult = deliverCargoEvent.someAction();
        CargoAggregate resultAggregate = someActionResult.getResult();
        return null;
    }
}
