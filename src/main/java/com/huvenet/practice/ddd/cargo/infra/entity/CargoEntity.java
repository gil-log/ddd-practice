package com.huvenet.practice.ddd.cargo.infra.entity;

import com.huvenet.practice.ddd.cargo.domain.model.Cargo;
import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import com.huvenet.practice.ddd.core.domain.DomainModel;
import com.huvenet.practice.ddd.core.infra.BaseEntity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class CargoEntity extends BaseEntity {

    private int length;
    private int weight;

    protected CargoEntity() {
    }

    @Builder(
        builderClassName = "init"
        , builderMethodName = "initByAll"
    )
    protected CargoEntity(int length, int weight) {
        this.length = length;
        this.weight = weight;
    }

    @Builder(
        builderMethodName = "initByModel"
    )
    private CargoEntity(Cargo cargo) {
        this.length = cargo.getCapacity().getLength();
        this.weight = cargo.getCapacity().getWeight();
        this.id = cargo.getId();
        this.createdAt = cargo.getCreatedAt();
        this.updatedAt = cargo.getUpdatedAt();
    }

    @Override
    public Cargo toModel() {
        return Cargo.initByAll().capacity(Capacity.initByAll().length(length).weight(weight).build()).id(id).updatedAt(updatedAt).createdAt(createdAt).build();
    }

}
