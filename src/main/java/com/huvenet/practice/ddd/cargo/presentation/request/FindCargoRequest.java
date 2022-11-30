package com.huvenet.practice.ddd.cargo.presentation.request;

import com.huvenet.practice.ddd.core.presentation.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindCargoRequest extends BaseRequest {

    private CargoCategory category;

    public enum CargoCategory {
        DELIVER, RECEIVER
    }
}
