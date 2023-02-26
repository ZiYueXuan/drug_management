package com.xjtuse.drug_management.controller;

import com.alibaba.fastjson.JSONObject;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.service.InitService;
import com.xjtuse.drug_management.utils.ClassifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class InitController {
    @Autowired
    private InitService initService;

    @PostMapping("/init/class")
    public String initClass(){
        String path = "E:\\Java_Programme\\drug_management\\src\\main\\resources\\templates\\classify.json";
        JSONObject jsonObject = ClassifyUtil.readJsonFile(path);
        Set<String> classes = ClassifyUtil.getClasses(jsonObject);
        for (String s:classes){
            Class c = new Class(1,s);
            initService.initClass(c);
        }
        return "药物类别已初始化";
    }
}
