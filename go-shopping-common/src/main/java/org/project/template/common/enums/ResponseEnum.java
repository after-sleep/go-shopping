package org.project.template.common.enums;

public enum ResponseEnum {

    SYSTEM_ERROR("system.error", "系统异常"),
    PARAM_VALUE_INVALID("param.value.invalid", "参数值无效"),;

    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
