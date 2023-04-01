package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.service.ClassService;
import com.xjtuse.drug_management.service.DrugService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {
    @Resource
    private ClassService classService;
    @Resource
    private DrugService drugService;

    @PostMapping("/manager/getRepositories")
    public List<Class> getRepositories() {
        return classService.getAll();
    }

    @PostMapping("/manager/addRepository")
    public String addRepository(String className) {
        String result = "药物信息库已建立";
        Class c = new Class(1, className);
        classService.add(c);
        return result;
    }

    @PostMapping("/manager/getDrugs")
    public List<Drug> getDrugs(int classId) {
        return drugService.getDrugByClass(classId);
    }

}
