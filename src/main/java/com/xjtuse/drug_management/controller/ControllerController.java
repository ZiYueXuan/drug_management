package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.ControllerExamine;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import com.xjtuse.drug_management.domain.pojo.Report;
import com.xjtuse.drug_management.domain.vo.ControllerExamineVO;
import com.xjtuse.drug_management.service.ControllerService;
import com.xjtuse.drug_management.service.ReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class ControllerController {
    @Resource
    private ControllerService controllerService;
    @Resource
    private ReportService reportService;

    @PostMapping("/getExaminedReports")
    public List<Report> getExaminedReports(int controllerId) {
        List<InspectorExamine> examines = controllerService.getExaminedReports(controllerId);
        List<Report> examinedReports = new ArrayList<>();
        for (InspectorExamine examine : examines) {
            Report report = examine.getReport();
            examinedReports.add(report);
        }
        return examinedReports;
    }

    @PostMapping("/examineReport")
    public void examineReport(ControllerExamineVO controllerExamineVO) {
        Report report = reportService.getReportById(controllerExamineVO.getReportId());
        Controller controller = controllerService.getControllerById(controllerExamineVO.getControllerId());
        ControllerExamine controllerExamine = new ControllerExamine(1, report,
                controllerExamineVO.getStatus(), controllerExamineVO.getOpinion(),
                controllerExamineVO.getTime(), controller);
        controllerService.examine(controllerExamine);
    }
}
