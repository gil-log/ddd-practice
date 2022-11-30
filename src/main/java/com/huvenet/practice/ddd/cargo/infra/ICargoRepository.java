package com.huvenet.practice.ddd.cargo.infra;

import com.huvenet.practice.ddd.cargo.domain.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoRepository extends JpaRepository<Cargo, Long> {

}
