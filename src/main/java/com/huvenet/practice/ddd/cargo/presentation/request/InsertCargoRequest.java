package com.huvenet.practice.ddd.cargo.presentation.request;

import com.huvenet.practice.ddd.core.presentation.BaseRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InsertCargoRequest extends BaseRequest {

    private int length;
    private int weight;
    private User user;

    public enum User {
        DELIVER, RECEIVER
    }
}
