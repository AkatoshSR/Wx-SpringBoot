package com.sqx.shopwx.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(20000, "成功"),
    FAIL(20001, "失败");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
