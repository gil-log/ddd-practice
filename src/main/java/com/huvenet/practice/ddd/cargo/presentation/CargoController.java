package com.huvenet.practice.ddd.cargo.presentation;

import com.huvenet.practice.ddd.cargo.application.DeliverAUseCase;
import com.huvenet.practice.ddd.cargo.application.ReceiverAUseCase;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest;
import com.huvenet.practice.ddd.cargo.presentation.request.FindCargoRequest.CargoCategory;
import com.huvenet.practice.ddd.cargo.presentation.response.FindCargoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final DeliverAUseCase deliverAUseCase;
    private final ReceiverAUseCase receiverAUseCase;

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
}
