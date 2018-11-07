package com.linkinstars;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * 转换器
 * @author LinkinStar
 */
public class Converter {

    /** json MediaType **/
    private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * 将请求体转换成OKHTTP可以识别的RequestBody
     * @param object 请求对象
     * @return RequestBody
     */
    public static <T> RequestBody requestBodyConverter(T object) {
        return RequestBody.create(JSON_TYPE, JSONObject.toJSONString(object));
    }

    /**
     * 将返回json字符串对象转换为实体对象
     * @param object 实体对象类型
     * @param jsonStr json字符串
     * @return 实体对象
     */
    public static <T> T responseBodyConverter(Class<T> object, String jsonStr) {
        return JSONObject.parseObject(jsonStr, object);
    }

    /**
     * 将返回json字符串对象转换为实体对象
     * @param typeReference 实体对象类型
     * @param jsonStr json字符串
     * @return 实体对象
     */
    public static <T> T responseBodyConverter(TypeReference<T> typeReference, String jsonStr) {
        return JSONObject.parseObject(jsonStr, typeReference);
    }

    /**
     * 将map转换成okhttp可以识别的FormBody对象
     * @param map 请求的表单数据
     * @return 可以发送的表单数据
     */
    public static FormBody formBodyConverter(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : map.keySet()) {
            builder.add(key, map.get(key));  
        }
        return builder.build();
    }
}
