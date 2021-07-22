package com.jwt.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Can.Ru
 */
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 5454155825314639342L;
    @ApiModelProperty(
            position = 98,
            required = true,
            value = "服务端返回请求结果的时间"
    )
    private Long timeStamp = System.currentTimeMillis();
    @ApiModelProperty(
            position = 99,
            value = "调用是否成功,必须优先判断,勿作为业务,请使用CommonResponse<Boolean> 代替"
    )
    private Boolean success;
    @ApiModelProperty(
            position = 100,
            value = "当success=false,判断错误代码,显示>1说明有子异常错误"
    )
    private String errorCode = "0";
    @ApiModelProperty(
            position = 101,
            value = "当success=false,显示的错误描述信息"
    )
    private String errorMessage;
    @ApiModelProperty(
            position = 102,
            value = "返回业务结果(请明确返回):如:业务成功失败,JSON数据等"
    )
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(T results) {
        this.data = results;
    }

    public CommonResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public CommonResponse(String errorCode, String errorMessage, T results) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = results;
    }

    public CommonResponse(boolean success, T results) {
        this.success = success;
        this.data = results;
    }

    public CommonResponse(boolean success, String errorCode, String errorMessage, T results) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = results;
        this.success = success;
    }

    public Long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T results) {
        this.data = results;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static <T> CommonResponse<T> success() {
        CommonResponse<T> commonResponse = new CommonResponse("0", "");
        commonResponse.setSuccess(Boolean.TRUE);
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(T t) {
        CommonResponse<T> commonResponse = new CommonResponse("0", "", t);
        commonResponse.setSuccess(Boolean.TRUE);
        return commonResponse;
    }

    public static <T> CommonResponse<T> success(T t, String errorCode, String errorMsg) {
        CommonResponse<T> commonResponse = new CommonResponse(errorCode, errorMsg, t);
        commonResponse.setSuccess(Boolean.TRUE);
        return commonResponse;
    }

    public static <T> CommonResponse<T> error(String errorCode, String errorMsg) {
        CommonResponse<T> commonResponse = new CommonResponse(errorCode, errorMsg);
        commonResponse.setSuccess(Boolean.FALSE);
        return commonResponse;
    }

    public static <T> CommonResponse<T> error(String errorCode, String errorMsg, T t) {
        CommonResponse<T> commonResponse = new CommonResponse(errorCode, errorMsg, t);
        commonResponse.setSuccess(Boolean.FALSE);
        return commonResponse;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommonResponse)) {
            return false;
        } else {
            CommonResponse<?> other = (CommonResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$timeStamp = this.getTimeStamp();
                    Object other$timeStamp = other.getTimeStamp();
                    if (this$timeStamp == null) {
                        if (other$timeStamp == null) {
                            break label71;
                        }
                    } else if (this$timeStamp.equals(other$timeStamp)) {
                        break label71;
                    }

                    return false;
                }

                Object this$success = this.getSuccess();
                Object other$success = other.getSuccess();
                if (this$success == null) {
                    if (other$success != null) {
                        return false;
                    }
                } else if (!this$success.equals(other$success)) {
                    return false;
                }

                label57: {
                    Object this$errorCode = this.getErrorCode();
                    Object other$errorCode = other.getErrorCode();
                    if (this$errorCode == null) {
                        if (other$errorCode == null) {
                            break label57;
                        }
                    } else if (this$errorCode.equals(other$errorCode)) {
                        break label57;
                    }

                    return false;
                }

                Object this$errorMessage = this.getErrorMessage();
                Object other$errorMessage = other.getErrorMessage();
                if (this$errorMessage == null) {
                    if (other$errorMessage != null) {
                        return false;
                    }
                } else if (!this$errorMessage.equals(other$errorMessage)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data == null) {
                        return true;
                    }
                } else if (this$data.equals(other$data)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommonResponse;
    }

    @Override
    public String toString() {
        return "CommonResponse(timeStamp=" + this.getTimeStamp() + ", success=" + this.getSuccess() + ", errorCode=" + this.getErrorCode() + ", errorMessage=" + this.getErrorMessage() + ", data=" + this.getData() + ")";
    }
}
