package com.example.jpaspringboot.response;

public enum ResultCodeSet {

    SUCCESS_COMMON(200, "SUCCESS"),


    FAIL(420, "FAIL")
    ;

    public int code;
    public String message;
    // Constructor
    private ResultCodeSet(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
