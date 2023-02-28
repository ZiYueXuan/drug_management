package com.xjtuse.drug_management.controller;

import com.alibaba.fastjson.JSONObject;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Classify;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.domain.vo.ClassifyVo;
import com.xjtuse.drug_management.service.InitService;
import com.xjtuse.drug_management.utils.ClassifyUtil;
import com.xjtuse.drug_management.utils.DrugUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class InitController {
    @Resource
    private InitService initService;

    private final String path = "E:\\Java_Programme\\drug_management\\src\\main\\resources\\templates\\classify.json";

    @PostMapping("/init/class")
    public String initClass(){
        JSONObject jsonObject = ClassifyUtil.readJsonFile(path);
        Set<String> classes = ClassifyUtil.getClasses(jsonObject);
        for (String s:classes){
            Class c = new Class(1,s);
            initService.initClass(c);
        }
        return "药物大类已初始化";
    }

    @PostMapping("/init/classify")
    public String initClassify(){
        JSONObject jsonObject = ClassifyUtil.readJsonFile(path);
        List<ClassifyVo> classifyVoList = ClassifyUtil.getClassifyVo(jsonObject);
        for (ClassifyVo classifyVo:classifyVoList){
            Class c = initService.getClassByName(classifyVo.getClassZ());
            String name = classifyVo.getClassifyName();
            String classifyId = classifyVo.getClassifyId();
            Classify classify = new Classify(1,c,name,classifyId);
            initService.initClassify(classify);
        }
        return "药物小类已初始化";
    }

    @PostMapping("/init/drugs")
    public String initDrugs(int classId){
        List<Classify> classifies = initService.getClassifyByClassId(classId);
        for (Classify classify:classifies) {
            final int searchType = 1;
            List<Drug> drugs = DrugUtil.getDrugs(classify.getClassifyId(), searchType);
            for (int i=0;i<drugs.size();i+=2) {
                Drug drug = drugs.get(i);
                initService.initDrug(drug);
            }
        }
        return "Class"+classId+"所属药物已插入";
    }
}
