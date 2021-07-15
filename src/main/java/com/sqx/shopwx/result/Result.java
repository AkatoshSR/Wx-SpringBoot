package com.sqx.shopwx.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "全局统一返回结果集")
public class Result<T> {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiModelProperty(value = "返回信息")
    private String message;

    // 携带data数据的返回成功
    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    // 不携带数据的返回成功
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    // 返回失败
    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(msg);
        return result;
    }


}
