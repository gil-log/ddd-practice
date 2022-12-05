package com.huvenet.practice.ddd.cargo.infra;

import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import org.springframework.data.domain.Page;

public interface CargoPersistent {

    CargoAggregate insertCargo(CargoAggregate cargoAggregate);

    boolean updateCargoStatus(CargoAggregate cargoAggregate);

    Page<CargoAggregate> selectCargoUsableList(CargoAggregate cargoAggregate);
}
