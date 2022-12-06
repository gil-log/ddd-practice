package com.huvenet.practice.ddd.cargo.domain.model.vo;

import com.huvenet.practice.ddd.core.domain.ValueObject;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;

@Embeddable
public class Capacity extends ValueObject {

    // Domain : Capacity는 Length, Width값이 0이 아닌 양수 값을 가져야 한다.
    // Domain : Capacity는의 Length와 Width의 총합은 300 미만 이어야 한다.
    private final int MAX_SUM = 300;
    @Getter
    private int length;
    @Getter
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
        validatePlusValue(length);
        validatePlusValue(weight);
        validateLengthPlusWeightMax(length, weight);
        this.length = length;
        this.weight = weight;
    }

    private void validatePlusValue(int value) {
        if(value <= 0) throw new IllegalArgumentException("0보다 작은 용량은 적재할 수 없습니다.");
    }

    private void validateLengthPlusWeightMax(int length, int weight) {
        if(length + weight > MAX_SUM) throw new IllegalArgumentException("길이와 무게의 총합이 적재 기준에 초과되었습니다.");
    }
}
