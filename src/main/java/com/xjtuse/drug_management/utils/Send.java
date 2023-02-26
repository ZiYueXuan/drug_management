package com.xjtuse.drug_management.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Send {
    private static final String appId = "mi86AXN4YlmfNPYy";
    private static final String appSecurity = "mi86AXN4YlmfNPYyQjLSPra67YWBugHB";
    private static final String drugURL = "https://api.shumaidata.com/v10/medical_v2/detail";
    private static final String classURL = "https://api.shumaidata.com/v10/medical_v2/type";

    /**
     * 此方法用来爬取药物信息
     * */
    public static JSONObject sendPost(String url,
                                      String appId,
                                      String applySecurity,
                                      String classifyId,
                                      int searchType,
                                      String searchKey){
        long time = System.currentTimeMillis();
        String sign = encrypt(time,appId,applySecurity);
        url = url+
                "?appid="+appId+
                "&timestamp="+time+
                "&sign="+sign+
                "&classifyId="+classifyId+
                "&searchType="+searchType+
                "&searchKey="+searchKey;
        return getJSON(url);
    }

    /**
     * 此方法用来获取药物的分类
     * */
    public static void getClassify(String url, String appId, String appSecurity){
        long time = System.currentTimeMillis();
        String sign = encrypt(time,appId,appSecurity);
        url = url+
                "?appid="+appId+
                "&timestamp="+time+
                "&sign="+sign;
        JSONObject result = getJSON(url);
        writeJsonFile(result);
    }

    //获取签名密文
    private static String encrypt(long time,String appId,String appSecurity){
        // 获取密文
        String encrypt = appId+"&"+time+"&"+appSecurity;
        // 进行MD5加密，得到签名
        return DigestUtils.md5Hex(encrypt);
    }
    //获取JSON对象
    private static JSONObject getJSON(String url){
        JSONObject result = new JSONObject();
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
    //保存JSON文件
    private static void writeJsonFile(JSONObject jsonObject){
        String content = JSON.toJSONString(jsonObject,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        try {
            File file = new File("E:\\Java_Programme\\drug_management\\src\\main\\resources\\templates\\classify.json");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            // 写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            write.write(content);
            System.out.println("文件写入成功");
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
