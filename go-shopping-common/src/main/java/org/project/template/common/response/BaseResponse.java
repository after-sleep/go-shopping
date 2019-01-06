package org.project.template.common.response;

import lombok.Data;
import org.project.template.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * 通用响应对象
 */
@Data
public class BaseResponse<T> implements Serializable {

    private boolean success;

    private int result;

    private String msgCode;

    private String message;

    private T data;

    private BaseResponse() {
        this.success = true;
        this.result = 1;
        this.msgCode = "success";
        this.message = "成功";
    }

    private BaseResponse(boolean success, int result, String msgCode, String message, T data) {
        this.success = success;
        this.result = result;
        this.msgCode = msgCode;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse success() {
        return new BaseResponse();
    }

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> success(String code, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setData(data);
        response.setMsgCode(code);
        return response;
    }

    public static <T> BaseResponse<T> fail(String msgCode, String message) {
        return new BaseResponse<>(false, 0, msgCode, message, null);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>(false, 0, ResponseEnum.SYSTEM_ERROR.getCode(), message, null);
    }

}
