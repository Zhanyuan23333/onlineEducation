package com.drill.common.constants;

import lombok.Getter;

import java.util.concurrent.PriorityBlockingQueue;


public enum ResultCodeEnum {

    SUCCESS(true,20000,"成功"),

    UNKNOWN_REASON(false,20001,"未知错误"),
    BAD_SQL_GRAMMAR(false,20002,"sql语法错误"),
    JSON_PARSE_ERROR(false,20003,"json解析异常"),
    PARAM_ERROR(false,20004,"参数错误"),
    FILE_UPLOAD_ERROR(false,20005,"文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false,20006,"excel数据导入错误");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
