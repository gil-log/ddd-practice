package com.huvenet.practice.ddd.cargo.infra;

import com.huvenet.practice.ddd.cargo.domain.model.Cargo;
import com.huvenet.practice.ddd.cargo.infra.entity.CargoEntity;
import com.huvenet.practice.ddd.cargo.domain.model.CargoAggregate;
import javax.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Log4j2
@RequiredArgsConstructor
@Repository
public class DeliverCargoPersistent implements CargoPersistent {

    private final ICargoRepository cargoRepository;


    @Override
    public CargoAggregate insertCargo(CargoAggregate cargoAggregate) {
        CargoEntity cargoEntity = CargoEntity.initByModel().cargo(cargoAggregate.getRoot()).build();
        try {
            cargoRepository.save(cargoEntity);
        } catch (PersistenceException e) {
            log.error("[DeliverCargoPersistent [insertCargo]] - ", e);
            return CargoAggregate.initEmpty().build();
        }
        return CargoAggregate.initByRoot().cargo(cargoEntity.toModel()).build();
    }

    @Override
    public boolean updateCargoStatus(CargoAggregate cargoAggregate) {
        return false;
    }

    @Override
    public Page<CargoAggregate> selectCargoUsableList(CargoAggregate cargoAggregate) {
        return null;
    }
}
