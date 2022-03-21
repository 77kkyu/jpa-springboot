package com.example.jpaspringboot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {

    private int status;

    private String message;

    private Object data;

    public ResponseMessage(ResultCodeSet resultCodeSet, Object data) {
        this.status = resultCodeSet.code;
        this.message = resultCodeSet.message;
        this.data = data;
    }

    public ResponseMessage(ResultCodeSet resultCodeSet) {
        this.status = resultCodeSet.code;
        this.message = resultCodeSet.message;
    }



}
