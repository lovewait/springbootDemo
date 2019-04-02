package com.example.demo.entity;

public class CommonResponseEntity<T> {
    private final int status;
    private final String message;
    private T data;

    private static final int SUCCESS_STATUS = 200;
    private static final int DEFAULT_STATUS = SUCCESS_STATUS;
    private static final String DEFAULT_MESSAGE = "ok";

    public CommonResponseEntity(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CommonResponseEntity(int status, String message){
        this.status = status;
        this.message = message;
    }

    public static <T> CommonResponseEntity<T> success(T data){
        return new CommonResponseEntity<>(DEFAULT_STATUS, DEFAULT_MESSAGE, data);
    }

    public static <T> CommonResponseEntity<T> error(int status, String message){
        return new CommonResponseEntity<>(status, message);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
