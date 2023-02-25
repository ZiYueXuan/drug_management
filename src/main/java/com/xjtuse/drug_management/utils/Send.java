package com.xjtuse.drug_management.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Send {
    public static JSONObject sendPost(String url,
                                      String appId,
                                      String applySecurity,
                                      String classifyId,
                                      int searchType,
                                      String searchKey){
        long time = System.currentTimeMillis();
        // 获取密文
        String encrypt = appId+"&"+time+"&"+applySecurity;
        // 进行MD5加密，得到签名
        String sign = MD5Test.encryptToMD5(encrypt);
        JSONObject result = new JSONObject();
        url = url+
                "?appid="+appId+
                "&timestamp="+time+
                "&sign="+sign+
                "&classifyId="+classifyId+
                "&searchType="+searchType+
                "&searchKey="+searchKey;
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try{
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode()==200) {
                result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch(IOException e){
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
        return result;
    }

    public static void main(String[] args) {
        String appId = "mi86AXN4YlmfNPYy";
        String applySecurity = "mi86AXN4YlmfNPYyQjLSPra67YWBugHB";
        String classifyId = "599ad280600b2149d689b5c5";
        int searchType = 1;
        String searchKey = "阿司匹林";
        String url = "https://api.shumaidata.com/v10/medical_v2/detail";
        JSONObject result = sendPost(url, appId, applySecurity, classifyId, searchType, searchKey);
        System.out.println(result);
    }
}
