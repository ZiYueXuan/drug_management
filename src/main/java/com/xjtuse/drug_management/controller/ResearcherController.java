package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Apply;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import com.xjtuse.drug_management.domain.vo.ApplyVO;
import com.xjtuse.drug_management.service.ApplyService;
import com.xjtuse.drug_management.service.DrugService;
import com.xjtuse.drug_management.service.ResearcherService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResearcherController {
    @Resource
    private ApplyService applyService;
    @Resource
    private ResearcherService researcherService;
    @Resource
    private DrugService drugService;

    @PostMapping("/researcher/drugApply")
    public String drugApply(@NotNull @RequestParam ApplyVO applyVO) {
        Researcher researcher = researcherService.getResearcherById(applyVO.getResearcherId());
        Drug drug = drugService.getDrugById(applyVO.getDrugId());
        Apply apply = new Apply(1, researcher, drug, applyVO.getNumber(), applyVO.getStatus());
        applyService.insert(apply);
        return "实验药物已申请";
    }

    @PostMapping("/researcher/getApplies")
    public List<Apply> getApplies() {
        return applyService.getApplies();
    }

    @PostMapping("/researcher/getApplies")
    public List<Apply> getApplies(@RequestParam int status) {
        return applyService.getApplies(status);
    }
}
