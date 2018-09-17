package com.linkinstars;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 发送http请求的客户端
 * @author LinkinStar
 */
public class ClientUtil {

    /** 最大连接数 **/
    private static final int MAX_IDLE_CONNECTIONS = 50;
    /** 保持连接时间 **/
    private static final int KEEP_ALIVE_DURATION = 5;
    /** 请求读取超时时间 **/
    private static final int READ_TIMEOUT = 15;
    /** 请求超时时间 **/
    private static final int CONNECTION_TIMEOUT = 15;

    /** 构建OKHTTP请求客户端 **/
    private static OkHttpClient OK_HTTP_CLIENT  = new OkHttpClient.Builder()
            .connectionPool(new ConnectionPool(MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION, TimeUnit.MINUTES))
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS).build();

    /**
     * 构建get json格式请求
     * @param url 请求地址
     * @return 返回数据
     */
    public static ResponseAndStatus getJson(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return sendMethod(request);
    }

    /**
     * 构建post json格式请求
     * @param url 请求地址
     * @return 返回数据
     */
    public static ResponseAndStatus postJson(String url, RequestBody requestBody) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return sendMethod(request);
    }

    /**
     * 构建post 表单格式请求
     * @param url 请求地址
     * @return 返回数据
     */
    public static ResponseAndStatus postForm(String url, FormBody formBody) {
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        return sendMethod(request);
    }

    /**
     * 抽离发送请求方法
     * @param request 请求本身      
     * @return 返回数据
     */
    private static ResponseAndStatus sendMethod(Request request) {
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            return new ResponseAndStatus<>(Status.NET_ERR, e.getMessage());
        }

        JSONObject jsonObject;
        String responseStr = null;
        try {
            responseStr = response.body().string();
            if (!response.isSuccessful()) {
                return new ResponseAndStatus<>(Status.NET_ERR, responseStr);
            }
            jsonObject = JSONObject.parseObject(responseStr);
            if (jsonObject == null) {
                return new ResponseAndStatus<>(Status.RESPONSE_FORMAT_ERR, responseStr);
            }
        } catch (IOException e) {
            return new ResponseAndStatus<>(Status.NET_ERR, e.getMessage());
        } catch (JSONException e) { 
            return new ResponseAndStatus<>(Status.JSON_FORMAT_ERR, responseStr);
        }

        return new ResponseAndStatus<>(Status.SUCCESS, jsonObject);
    }

}
