package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Apply;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.service.ApplyService;
import com.xjtuse.drug_management.service.ClassService;
import com.xjtuse.drug_management.service.DrugService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Resource
    private ClassService classService;
    @Resource
    private DrugService drugService;
    @Resource
    private ApplyService applyService;

    @PostMapping("/getRepositories")
    public List<Class> getRepositories() {
        return classService.getAll();
    }

    @PostMapping("/addRepository")
    public String addRepository(String className) {
        String result = "药物信息库已建立";
        Class c = new Class(1, className);
        classService.add(c);
        return result;
    }

    @PostMapping("/getDrugs")
    public List<Drug> getDrugs(int classId) {
        return drugService.getDrugByClass(classId);
    }

    @PostMapping("/getApplies")
    public List<Apply> getApplies() {
        List<Apply> applies = applyService.getApplies();
        for (Apply apply : applies) {
            applyService.updateStatus(apply, 2);
        }
        return applies;
    }

    @PostMapping("/getAppliesWithResearcher")
    public List<Apply> getApplies(@RequestParam int researcherId) {
        List<Apply> applies = applyService.getApplies(researcherId);
        for (Apply apply : applies) {
            applyService.updateStatus(apply, 2);
        }
        return applies;
    }

    @PostMapping("/exeApply")
    public String exeApply(@NotNull Apply apply) {
        Drug drug = apply.getDrug();
        int number = apply.getNumber();
        // 判断药物库存是否大于申请的数量
        if (drug.getNumber() > number) {
            drugService.updateNumber(drug, number);
        }
        applyService.updateStatus(apply, 3);
        return "药品" + drug.getName() + "已发放";
    }
}
