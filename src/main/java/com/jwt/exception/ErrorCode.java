package com.jwt.exception;


/**
 * @author Can.Ru
 */
public class ErrorCode extends RuntimeException {

    private Integer code;

    private String message;

    public ErrorCode(String message) {
        super(message);
    }


    public ErrorCode(Integer code,String message) {
        this(code, message, (Throwable)null);
        this.code =code;
        this.message = message;
    }

    public ErrorCode(Integer code,String message, Throwable cause) {
        super(message,cause);
        this.code =code;
        this.message = message;
    }

    public static void throwException(Integer code,String message) {
        throw new ErrorCode(code,message);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
