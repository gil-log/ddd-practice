package com.huvenet.practice.ddd.cargo.domain.model.vo;

import com.huvenet.practice.ddd.core.domain.ValueObject;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LengthAtomic extends ValueObject {

    // Domain : 양수 값을 가져야 한다.
    private int value;

    private LengthAtomic() {
    }

    @Builder(
        builderMethodName = "initByValue"
    )
    private LengthAtomic(int value) {
        validatePlusValue(value);
        this.value = value;
    }

    private void validatePlusValue(int value) {
        if(value < 0) throw new IllegalArgumentException("길이는 음수 값이 올 수 없습니다.");
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }
}
