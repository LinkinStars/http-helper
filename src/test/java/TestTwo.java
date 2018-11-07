import com.alibaba.fastjson.TypeReference;
import com.linkinstars.HttpHelper;
import com.linkinstars.ResponseAndStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 单元测试
 * @author LinkinStar
 */
public class TestTwo {

    /**
     * get请求 单元测试
     */
    @org.junit.Test
    public void getUrl() {
        String getUrl = "http://127.0.0.1:8080/test/get";
        ResponseAndStatus<CommonResponse<SpecificData>> responseAndStatus = HttpHelper.getJson(getUrl, new TypeReference<CommonResponse<SpecificData>>(){});
        if (responseAndStatus.isSuccess()) {
            CommonResponse<SpecificData> commonResponse = responseAndStatus.getResponseData();
            SpecificData specificData = commonResponse.getData();
            System.out.println("请求成功返回： " + specificData.toString());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }
    }

    /**
     * post-json请求 单元测试
     */
    @org.junit.Test
    public void postJsonUrl() {
        String postUrl = "http://127.0.0.1:8080/test/get";
        SpecificData requestData = new SpecificData();
        requestData.setId(1);
        requestData.setName("xxx");
        requestData.setVal("val");

        ResponseAndStatus<CommonResponse<SpecificData>> responseAndStatus 
                = HttpHelper.postJson(postUrl, new TypeReference<CommonResponse<SpecificData>>(){}, requestData);
        if (responseAndStatus.isSuccess()) {
            CommonResponse<SpecificData> commonResponse = responseAndStatus.getResponseData();
            SpecificData specificData = commonResponse.getData();
            System.out.println("请求成功返回： " + specificData.toString());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }
    }

    /**
     * post-form请求 单元测试
     */
    @org.junit.Test
    public void postFormUrl() {
        String postUrl = "http://127.0.0.1:8080/test/get";

        Map<String, String> requestForm = new HashMap<>();
        requestForm.put("name", "xxx");
        requestForm.put("val", "123");
        
        ResponseAndStatus<CommonResponse<SpecificData>> responseAndStatus = HttpHelper.postForm(postUrl, new TypeReference<CommonResponse<SpecificData>>(){}, requestForm);
        if (responseAndStatus.isSuccess()) {
            CommonResponse<SpecificData> commonResponse = responseAndStatus.getResponseData();
            SpecificData specificData = commonResponse.getData();
            System.out.println("请求成功返回： " + specificData.toString());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }
    }
}
