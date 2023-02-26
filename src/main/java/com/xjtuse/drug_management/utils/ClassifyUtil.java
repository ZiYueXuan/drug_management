package com.xjtuse.drug_management.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;

public class ClassifyUtil {
    public static Set<String> getClasses(JSONObject jsonObject){
        Set<String> classSet = new HashSet<>();
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray jsonArray = data.getJSONArray("data");
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObjectI = jsonArray.getJSONObject(i);
            String className = jsonObjectI.getString("classz");
            classSet.add(className);
        }
        return classSet;
    }

    //读取json文件
    public static JSONObject readJsonFile(String filename){
        String jsonString = "";
        File jsonFile = new File(filename);
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = reader.read()) != -1){
                stringBuilder.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonString = stringBuilder.toString();
        } catch (FileNotFoundException e){
            JSONObject notFoundJson = new JSONObject();
            notFoundJson.put("code",400);
            notFoundJson.put("msg","该地区GeoJson文件不存在！");
            return notFoundJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(jsonString);
    }
}
