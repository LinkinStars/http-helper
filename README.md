# OKHttp封装

## 目标
调用方法传入url和一个类型，请求后，直接将‘返回的数据’映射到‘该类型的对象’中，并返回相应的请求状态

## 封装内容
封装OkHttp + fastjson为：
1. get请求  
2. post请求 json格式  
3. post请求 form格式  
要求请求返回格式都是为json格式   


## 使用和更新说明
**测试案例都在test包下**
<br><br>

Version 1.1.0
更新说明：
1. 在ResponseAndStatus添加isSuccess方法，用于判断当前请求是否成功。
2. 添加带有TypeReference请求的方法，解决泛型嵌套的返回类型的优化。  

````
针对更新中第2点具体说明：  
我们在实际使用中发现，一般收到的请求都是需要进行泛型嵌套的如：  
{"code":1,"data":{"val":"测试","name":"名称","id":1},"message":"请求成功"}  
我们需要一个类包含code，message，data字段，其中data字段去用泛型约束。  
如test包下CommonResponse和SpecificData
所以我们在调用第三方请求的时候，想传入的类型会有泛型，原来1.0.0的版本只能传class，有些鸡肋
我们利用TypeReference解决这个问题。

改动之后测试案例如下：

 ResponseAndStatus<CommonResponse<SpecificData>> responseAndStatus = HttpHelper.getJson(getUrl, new TypeReference<CommonResponse<SpecificData>>(){});
 
 最后第三方返回的json会映射到CommonResponse<SpecificData>里面并且泛型里面的类也会有相应的数据。
        
````

<br><br>

Version 1.0.0  

1、get请求  
````
    ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.getJson(getUrl, TestObject.class);  
    getUrl：请求地址  
    TestObject： 返回数据对象（自定义）返回的json数据会直接映射成对象中的属性，如果直接使用JSONObejct接收自己进行解析也可以
    responseAndStatus：包含请求状态，当状态为SUCCESS时请求成功，responseData为返回数据，当状态不为SUCCESS则responseData也会有请求数据，用于日志记录
````

2、post请求json  
````
    ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.postJson(postUrl, TestObject.class, requesObject);
    requesObject：请求对象，该对象为任意对象，会直接转换成json数据发送
    其余参数与get一致  
````

3、post请求form  
````
    ResponseAndStatus<TestObject> responseAndStatus = HttpHelper.postForm(postUrl, TestObject.class, requestForm);  
    requestForm：类型是map，其中key-value为表单中对应的数据  
    其余参数与get一致 
````

## 推送到本地仓库
执行build.gradle中的uploadArchives任务就可以推送到本地的Nexus仓库中进行使用，需要修改对应仓库地址。

