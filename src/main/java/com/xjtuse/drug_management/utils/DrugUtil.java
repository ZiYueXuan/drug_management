package com.xjtuse.drug_management.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjtuse.drug_management.domain.pojo.Drug;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DrugUtil {
    private static final String appId = "mi86AXN4YlmfNPYy";
    private static final String appSecurity = "mi86AXN4YlmfNPYyQjLSPra67YWBugHB";
    private static final String drugURL = "https://api.shumaidata.com/v10/medical_v2/detail";
    private static final String classURL = "https://api.shumaidata.com/v10/medical_v2/type";
    private static final String drugNameURL = "https://api.shumaidata.com/v10/medical_v2/info";

    /**
     * 此方法用来爬取药物信息
     */
    public static List<Drug> getDrugs(String classifyId, int searchType) {
        long time = System.currentTimeMillis();
        String sign = encrypt(time);
        Set<String> drugNameSet = getDrugName(classifyId);
        List<Drug> drugs = new ArrayList<>();
        for (String drugName : drugNameSet) {
            String url = drugURL +
                    "?appid=" + appId +
                    "&timestamp=" + time +
                    "&sign=" + sign +
                    "&classifyId=" + classifyId +
                    "&searchType=" + searchType +
                    "&searchKey=" + drugName;
            JSONObject jsonObject = getJSON(url);
            JSONObject data = jsonObject.getJSONObject("data");
            if (data != null) {
                JSONArray jsonArray = data.getJSONArray("drugList");
                if (jsonArray != null) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObjectI = jsonArray.getJSONObject(i);
                        String name = jsonObjectI.getString("drugName");
                        String drugId = jsonObjectI.getString("drugId");
                        String specification = jsonObjectI.getString("gg");
                        String form = jsonObjectI.getString("jx");
                        String approvalNumber = jsonObjectI.getString("pzwh");
                        String executiveStandard = jsonObjectI.getString("zxbz");
                        String producer = jsonObjectI.getString("manu");
                        String indication = jsonObjectI.getString("syz");
                        String component = jsonObjectI.getString("zycf");
                        String interact = jsonObjectI.getString("ywxhzy");
                        String properties = jsonObjectI.getString("xz");
                        int number = new Random().nextInt(1000);
                        float price = jsonObjectI.getFloat("price");
                        String validityTime = jsonObjectI.getString("yxq");
                        String usageConsumption = jsonObjectI.getString("yfyl");
                        String taboo = jsonObjectI.getString("jj");
                        String adverseReaction = jsonObjectI.getString("blfy");
                        String storeUp = jsonObjectI.getString("zc");
                        String matters = jsonObjectI.getString("zysx");
                        Drug drug = new Drug(1, name, drugId, specification,
                                form, approvalNumber, executiveStandard, producer,
                                indication, component, interact, properties, number,
                                price, validityTime, usageConsumption, taboo,
                                adverseReaction, storeUp, matters);
                        drugs.add(drug);
                    }
                }
            }
        }
        return drugs;
    }

    /**
     * 此方法用来获取药物的分类
     */
    public static void getClassify() {
        long time = System.currentTimeMillis();
        String sign = encrypt(time);
        String url = classURL +
                "?appid=" + appId +
                "&timestamp=" + time +
                "&sign=" + sign;
        JSONObject result = getJSON(url);
        writeJsonFile(result);
    }

    /**
     * 此方法用来获取药物名称
     */
    private static Set<String> getDrugName(String classifyId) {
        long time = System.currentTimeMillis();
        String sign = encrypt(time);
        String url = drugNameURL +
                "?appid=" + appId +
                "&timestamp=" + time +
                "&sign=" + sign +
                "&classifyId=" + classifyId;
        JSONObject jsonObject = getJSON(url);
        Set<String> drugNameSet = new HashSet<>();
        JSONObject data = jsonObject.getJSONObject("data");
        if (data != null) {
            JSONArray jsonArray = data.getJSONArray("data");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObjectI = jsonArray.getJSONObject(i);
                    String drugName = jsonObjectI.getString("drugName");
                    drugNameSet.add(drugName);
                }
            }
        }
        return drugNameSet;
    }

    //获取签名密文
    private static String encrypt(long time) {
        // 获取密文
        String encrypt = appId + "&" + time + "&" + appSecurity;
        // 进行MD5加密，得到签名
        return DigestUtils.md5Hex(encrypt);
    }

    //获取JSON对象
    private static JSONObject getJSON(String url) {
        JSONObject result = new JSONObject();
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
        return result;
    }

    //保存JSON文件
    private static void writeJsonFile(JSONObject jsonObject) {
        String content = JSON.toJSONString(jsonObject,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        try {
            File file = new File("E:\\Java_Programme\\drug_management\\src\\main\\resources\\templates\\classify.json");
            if (file.exists()) {
                boolean delete = file.delete();
            }
            boolean b = file.createNewFile();
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
