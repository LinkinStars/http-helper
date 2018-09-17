# OKHttp封装

## 目标
调用方法传入url和一个类型，请求后，直接将‘返回的数据’映射到‘该类型的对象’中，并返回相应的请求状态

## 封装内容
封装OkHttp + fastjson为：
1. get请求  
2. post请求 json格式  
3. post请求 form格式  
要求请求返回格式都是为json格式  

## 使用说明
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

具体使用方式在Test中有详细例子  

## 推送到本地仓库
执行build.gradle中的uploadArchives任务就可以推送到本地的Nexus仓库中进行使用，需要修改对应仓库地址。

