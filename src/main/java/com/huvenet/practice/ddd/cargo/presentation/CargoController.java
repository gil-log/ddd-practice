package com.huvenet.practice.ddd.cargo.presentation;

import com.huvenet.practice.ddd.cargo.application.DeliverAUseCase;
import com.huvenet.practice.ddd.cargo.application.DeliverInsertUseCase;
import com.huvenet.practice.ddd.cargo.application.ReceiverAUseCase;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest.CargoCategory;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.request.InsertCargoRequest.User;
import com.huvenet.practice.ddd.cargo.presentation.response.FindCargoResponse;
import com.huvenet.practice.ddd.cargo.presentation.response.InsertCargoResponse;
import com.huvenet.practice.ddd.cargo.presentation.response.InsertCargoResponse.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final DeliverAUseCase deliverAUseCase;
    private final ReceiverAUseCase receiverAUseCase;
    private final DeliverInsertUseCase deliverInsertUseCase;

    @GetMapping("")
    public ResponseEntity<FindCargoResponse> findCargo(FindCargoRequest request) {
        if(request.getCategory() == null) {
            return ResponseEntity.ok(null);
        } else if(request.getCategory().equals(CargoCategory.DELIVER)) {
            return ResponseEntity.ok(deliverAUseCase.execute(request));
        } else if(request.getCategory().equals(CargoCategory.RECEIVER)) {
            return ResponseEntity.ok(receiverAUseCase.execute(request));
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping("")
    public ResponseEntity<InsertCargoResponse> insertCargo(InsertCargoRequest request) {
        if(request.getLength() == 0 || request.getWeight() == 0) {
            return ResponseEntity.badRequest().body(InsertCargoResponse.initFail().code(ResponseCode.BAD_REQUEST).build());
        }
        if(request.getUser() == null) {
            request.setUser(User.DELIVER);
        }
        switch (request.getUser()) {
            case RECEIVER:
                return ResponseEntity.badRequest().body(InsertCargoResponse.initFail().code(ResponseCode.RECEIVER_CANNOT_CREATE).build());
            case DELIVER:
            default:
                InsertCargoResponse response = deliverInsertUseCase.execute(request);
                if(response.isSuccess()) {
                    return ResponseEntity.ok(response);
                }
                return ResponseEntity.status(response.getResponseCode().getHttpStatus()).body(response);
        }

    }
}
