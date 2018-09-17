package com.linkinstars;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * 调用入口
 * @author LinkinStar
 */
public class HttpHelper {

    /**
     * 发送get请求
     * @param url 请求地址
     * @param clazz 请求返回json封装的类型
     * @return 请求反馈
     */
    public static <T> ResponseAndStatus<T> getJson(String url, Class<T> clazz) {
        ResponseAndStatus<T> responseAndStatus = ClientUtil.getJson(url);
        return processResponse(clazz, responseAndStatus);
    }

    /**
     * 发送post请求-json格式
     * @param url 请求地址
     * @param clazz 请求返回json封装的类型
     * @param requestObject 请求对象
     * @return 请求反馈
     */
    public static <T> ResponseAndStatus<T> postJson(String url, Class<T> clazz, Object requestObject){
        RequestBody requestBody = Converter.requestBodyConverter(requestObject);
        ResponseAndStatus<T> responseAndStatus = ClientUtil.postJson(url, requestBody);
        return processResponse(clazz, responseAndStatus);
    }

    /**
     * 发送post请求-form
     * @param url 请求地址
     * @param clazz 请求返回json封装的类型
     * @param requestMap 请求表单数据
     * @return 请求反馈
     */
    public static <T> ResponseAndStatus<T> postForm(String url, Class<T> clazz, Map<String, String> requestMap){
        FormBody formBody = Converter.formBodyConverter(requestMap);
        ResponseAndStatus<T> responseAndStatus = ClientUtil.postForm(url, formBody);
        return processResponse(clazz, responseAndStatus);
    }
    
    private static <T> ResponseAndStatus<T> processResponse(Class<T> clazz, ResponseAndStatus<T> responseAndStatus){
        if (responseAndStatus.getStatus() != Status.SUCCESS) {
            return responseAndStatus;
        }
        T object = Converter.responseBodyConverter(clazz, responseAndStatus.getResponseData().toString());
        return new ResponseAndStatus<>(Status.SUCCESS, object);
    }
}
