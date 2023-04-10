package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import com.xjtuse.drug_management.domain.pojo.Report;
import com.xjtuse.drug_management.domain.vo.InspectorExamineVO;
import com.xjtuse.drug_management.service.ControllerService;
import com.xjtuse.drug_management.service.InspectorService;
import com.xjtuse.drug_management.service.ReportService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/inspector")
public class InspectorController {
    @Resource
    private ControllerService controllerService;
    @Resource
    private InspectorService inspectorService;
    @Resource
    private ReportService reportService;

    @PostMapping("/getReports")
    public List<Report> getReports(@RequestParam int inspectorId) {
        return reportService.getReports(inspectorId);
    }

    @PostMapping("/examineReport")
    public void examineReport(@NotNull InspectorExamineVO inspectorExamineVO) {
        Report report = reportService.getReportById(inspectorExamineVO.getReportId());
        Controller controller = controllerService.getControllerById(inspectorExamineVO.getControllerId());
        InspectorExamine inspectorExamine = new InspectorExamine(1, report, inspectorExamineVO.getStatus(),
                inspectorExamineVO.getOpinion(), inspectorExamineVO.getTime(), controller);
        inspectorService.examine(inspectorExamine);
    }
}
