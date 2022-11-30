package com.huvenet.practice.ddd.cargo.domain.vo;

import com.huvenet.practice.ddd.core.domain.ValueObject;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;

@Embeddable
@Getter
public class Capacity extends ValueObject {

    private int length;
    private int weight;

    protected Capacity() {
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Builder(
        builderMethodName = "initByAll"
    )
    private Capacity(int length, int weight) {
        this.length = length;
        this.weight = weight;
    }
}
