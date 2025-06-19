package com.xlx.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long timestamp;
    private String path;
    private String requestId;
    private int code;
    private String message;
    private T data;

    // 成功响应的静态工厂方法
    public static <T> ErrorMessageResult<T> success() {
        return success(0, "Operation successful", null, null, null);
    }

    public static <T> ErrorMessageResult<T> success(T data) {
        return success(0, "Operation successful", data, null, null);
    }

    public static <T> ErrorMessageResult<T> success(int code, String message, T data, String path, String requestId) {
        return new ErrorMessageResult<>(System.currentTimeMillis(), path, requestId, code, message, data);
    }

    // 失败响应的静态工厂方法
    public static <T> ErrorMessageResult<T> fail(int code, String message) {
        return fail(code, message, null, null, null);
    }

    public static <T> ErrorMessageResult<T> fail(int code, String message, T data, String path, String requestId) {
        return new ErrorMessageResult<>(System.currentTimeMillis(), path, requestId, code, message, data);
    }
}