import com.linkinstars.HttpHelper;
import com.linkinstars.ResponseAndStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 单元测试
 * @author LinkinStar
 */
public class Test {

    /**
     * get请求 单元测试
     */
    @org.junit.Test
    public void getUrl() {
        String getUrl = "http://127.0.0.1:8080/test/get";
        String geterrUrl = "http://127.0.0.1:8080/test/geterr";

        //1. 正常情况
        ResponseAndStatus<CommonResponse> responseAndStatus = HttpHelper.getJson(getUrl, CommonResponse.class);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.getJson(geterrUrl, CommonResponse.class);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getStatus() + "'  " +  responseAndStatus.getResponseData());
        }
    }

    /**
     * post-json请求 单元测试
     */
    @org.junit.Test
    public void postJsonUrl() {
        String postUrl = "http://127.0.0.1:8080/test/post";
        String posterrUrl = "http://127.0.0.1:8080/test/posterr";

        SpecificData specificData = new SpecificData();
        specificData.setId(1);
        specificData.setName("xxx");
        specificData.setVal("val");

        //1. 正常情况
        ResponseAndStatus<CommonResponse> responseAndStatus = HttpHelper.postJson(postUrl, CommonResponse.class, specificData);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.postJson(posterrUrl, CommonResponse.class, specificData);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getStatus() + "'  " +  responseAndStatus.getResponseData());
        }
    }

    /**
     * post-form请求 单元测试
     */
    @org.junit.Test
    public void postFormUrl() {
        String postUrl = "http://127.0.0.1:8080/test/post";
        String posterrUrl = "http://127.0.0.1:8080/test/posterr";

        Map<String, String> requestForm = new HashMap<>();
        requestForm.put("name", "xxx");
        requestForm.put("val", "123");
        
        //1. 正常情况
        ResponseAndStatus<CommonResponse> responseAndStatus = HttpHelper.postForm(postUrl, CommonResponse.class, requestForm);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.postForm(posterrUrl, CommonResponse.class, requestForm);
        if (responseAndStatus.isSuccess()) {
            CommonResponse commonResponse = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + commonResponse.getCode() + "   " + commonResponse.getMessage());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getStatus() + "'  " +  responseAndStatus.getResponseData());
        }
    }
}
