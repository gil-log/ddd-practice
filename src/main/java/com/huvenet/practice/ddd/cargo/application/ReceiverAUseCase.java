package com.huvenet.practice.ddd.cargo.application;

import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
import com.huvenet.practice.ddd.cargo.domain.event.ReceiverCargoEvent;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.response.FindCargoResponse;
import com.huvenet.practice.ddd.core.application.BaseUseCase;
import com.huvenet.practice.ddd.core.application.DomainResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReceiverAUseCase extends BaseUseCase<FindCargoRequest, FindCargoResponse> {

    private final ReceiverCargoEvent receiverCargoEvent;

    @Override
    public FindCargoResponse execute(FindCargoRequest request) {
        DomainResult<CargoAggregate> someActionResult = receiverCargoEvent.someAction();
        CargoAggregate resultAggregate = someActionResult.getResult();

        return null;
    }
}
