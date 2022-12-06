package com.huvenet.practice.ddd.cargo.domain.model;

import com.huvenet.practice.ddd.cargo.domain.model.vo.LengthAtomic;
import com.huvenet.practice.ddd.cargo.domain.model.vo.WidthAtomic;
import com.huvenet.practice.ddd.core.domain.DomainModel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CargoAtomic extends DomainModel {

    // Domain : 하나의 Cargo는 Length, Width를 가져야 한다.
    // Domain : 하나의 Cargo의 Length와 Width의 총합은 300 미만 이어야 한다.
    private LengthAtomic length;
    private WidthAtomic weight;

    private Object testReceiver;
    private Object testSender;
    private Object testCategory;

    private CargoAtomic() {
    }

    @Builder(
        builderMethodName = "initByLengthAndWeight"
    )
    private CargoAtomic(LengthAtomic length, WidthAtomic weight) {
        validateNonNullValue(length);
        validateNonNullValue(weight);
        validateLengthPlusWeightMax(length, weight);
        this.length = length;
        this.weight = weight;
    }

    private void validateNonNullValue(Object object) {
        if(object == null) throw new NullPointerException();
    }

    private void validateLengthPlusWeightMax(LengthAtomic length, WidthAtomic weight) {
        final int MAX_SUM = 300;
        if(length.getValue() + weight.getValue() > MAX_SUM) throw new IllegalArgumentException("길이와 무게의 총합이 적재 기준에 초과되었습니다.");
    }
}
