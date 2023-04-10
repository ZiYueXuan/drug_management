package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Report;

import java.util.List;

public interface ReportService {
    void insert(Report report);

    List<Report> getReports(int inspectorId);

    Report getReportById(int reportId);
}
