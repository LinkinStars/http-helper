package com.linkinstars;

/**
 * 自定义返回数据类型
 * @author LinkinStar
 */
public class ResponseAndStatus<T> {
    /** 请求返回状态 **/
    private Status status;
    /** 请求返回数据对象 **/
    private T responseData;

    public ResponseAndStatus(Status status, T responseData) {
        this.status = status;
        this.responseData = responseData;
    }

    public Status getStatus() {
        return status;
    }

    public T getResponseData() {
        return responseData;
    }
}
