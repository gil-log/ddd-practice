package com.huvenet.practice.ddd.cargo.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import com.huvenet.practice.ddd.cargo.domain.model.vo.Capacity;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CargoTest {

    @DisplayName("다른 builder class의 다른 method는 각각 값을 생성할 수 있다.")
    @Test
    public void testAnotherConstructObjectByDifferentBuilderMethod() {

        // Given
        Capacity capacity = Capacity.initByAll().length(100).weight(100).build();
        Long id = 1L;
        Date createdAt = new Date();
        Date updatedAt = new Date();

        // When
        Cargo cargoByInitByCapacity = Cargo.initByCapacity().capacity(capacity).build();
        Cargo cargoByInitByCapacityAndBase = Cargo.initByCapacityAndBase().capacity(capacity).id(id).createdAt(createdAt).updatedAt(updatedAt).build();

        // Then
        assertEquals(cargoByInitByCapacityAndBase.getId(), id);
    }
}
