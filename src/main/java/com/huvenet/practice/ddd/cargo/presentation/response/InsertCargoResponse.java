package com.huvenet.practice.ddd.cargo.presentation.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huvenet.practice.ddd.core.presentation.BaseResponse;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(value = {"ResponseCode"})
@Getter
@Setter
public class InsertCargoResponse extends BaseResponse {

    private ResponseCode responseCode;
    private Body result;

    @Getter
    @RequiredArgsConstructor
    public enum ResponseCode {
        OK(0, "OK", HttpStatus.OK),
        BAD_REQUEST(1, "필수 파라미터가 존재하지 않습니다.", HttpStatus.BAD_REQUEST),
        JUST_FAILED(1000, "그냥 실패 했음", HttpStatus.INTERNAL_SERVER_ERROR),
        HUK_WHY(1100, "헉 왜???", HttpStatus.INTERNAL_SERVER_ERROR),
        RECEIVER_CANNOT_CREATE(1200, "수신자는 화물을 생성할 수 없습니다.", HttpStatus.BAD_REQUEST);
        private final int innerCode;
        private final String message;
        private final HttpStatus httpStatus;
    }


    @Getter
    @Setter
    @ToString
    public static class Body {
        private Long id;
        private int length;
        private int weight;
        private Date createdAt;
        private Date updatedAt;

        private Body() {

        }

        @Builder(
            builderMethodName = "init"
        )
        private Body(Long id, int length, int weight, Date createdAt, Date updatedAt) {
            this.id = id;
            this.length = length;
            this.weight = weight;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }

    @Builder(
        builderMethodName = "initFail"
    )
    private InsertCargoResponse(ResponseCode code) {
        super(code.innerCode, code.message);
        this.responseCode = code;
    }


    @Builder(
        builderMethodName = "initBody"
    )
    private InsertCargoResponse(Long id, int length, int weight, Date createdAt, Date updatedAt) {
        this.result = Body.init()
            .id(id)
            .length(length)
            .weight(weight)
            .createdAt(createdAt)
            .updatedAt(updatedAt)
            .build();
    }
}
