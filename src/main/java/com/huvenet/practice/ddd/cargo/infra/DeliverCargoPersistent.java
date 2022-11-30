package com.huvenet.practice.ddd.cargo.infra;

import com.huvenet.practice.ddd.cargo.domain.entity.Cargo;
import com.huvenet.practice.ddd.cargo.domain.entity.CargoAggregate;
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
        Cargo cargo = cargoAggregate.getRoot();
        try {
            cargoRepository.save(cargo);
        } catch (PersistenceException e) {
            log.error("[DeliverCargoPersistent [insertCargo]] - ", e);
            return CargoAggregate.initEmpty().build();
        }
        return CargoAggregate.initByRoot().cargo(cargo).build();
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
