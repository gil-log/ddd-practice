package com.huvenet.practice.ddd.cargo.infra;

import com.huvenet.practice.ddd.cargo.infra.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoRepository extends JpaRepository<CargoEntity, Long> {

}
