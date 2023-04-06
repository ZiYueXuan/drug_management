package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.*;
import com.xjtuse.drug_management.domain.vo.ApplyVO;
import com.xjtuse.drug_management.domain.vo.ReportVO;
import com.xjtuse.drug_management.service.*;
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
    @Resource
    private InspectorService inspectorService;
    @Resource
    private ReportService reportService;

    @PostMapping("/researcher/drugApply")
    public String drugApply(@NotNull @RequestParam ApplyVO applyVO) {
        Researcher researcher = researcherService.getResearcherById(applyVO.getResearcherId());
        Drug drug = drugService.getDrugById(applyVO.getDrugId());
        Apply apply = new Apply(1, researcher, drug,
                applyVO.getNumber(), applyVO.getStatus());
        applyService.insert(apply);
        return "实验药物已申请";
    }

    @PostMapping("/researcher/getApplies")
    public List<Apply> getApplies(@RequestParam int researcherId) {
        return applyService.getApplies(researcherId);
    }

    @PostMapping("/researcher/getApplies")
    public List<Apply> getApplies(@RequestParam int researcherId, @RequestParam int status) {
        return applyService.getApplies(researcherId, status);
    }

    /**
     * 这里差一个实现药物重定位的接口
     */

    @PostMapping("/api/researcher/createReport")
    public String createReport(@NotNull ReportVO reportVO) {
        Researcher researcher = researcherService.getResearcherById(reportVO.getResearcher_id());
        Inspector inspector = inspectorService.getInspectorById(reportVO.getInspector_id());
        Report report = new Report(1, researcher, reportVO.getTitle(),
                reportVO.getContent(), reportVO.getTime(), reportVO.getAppendix(), inspector);
        reportService.insert(report);
        return "研究报告已撰写并提交";
    }
}
