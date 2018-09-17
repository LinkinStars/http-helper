import com.linkinstars.HttpHelper;
import com.linkinstars.ResponseAndStatus;
import com.linkinstars.Status;

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
        ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.getJson(getUrl, TestObject.class);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.getJson(geterrUrl, TestObject.class);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
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
        
        TestObject requesObject = new TestObject();
        requesObject.setName("xxx");
        requesObject.setVal(123);

        //1. 正常情况
        ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.postJson(postUrl, TestObject.class, requesObject);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.postJson(posterrUrl, TestObject.class, requesObject);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
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
        ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.postForm(postUrl, TestObject.class, requestForm);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getResponseData());
        }

        //2. 返回值异常
        responseAndStatus = HttpHelper.postForm(posterrUrl, TestObject.class, requestForm);
        if (responseAndStatus.getStatus() == Status.SUCCESS) {
            TestObject testObject = responseAndStatus.getResponseData();
            System.out.println("请求成功返回： " + testObject.getName() + "   " + testObject.getVal());
        } else {
            System.out.println("请求失败返回： " + responseAndStatus.getStatus() + "'  " +  responseAndStatus.getResponseData());
        }
    }
}
