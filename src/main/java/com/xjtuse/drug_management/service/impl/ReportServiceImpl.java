package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ReportMapper;
import com.xjtuse.drug_management.domain.pojo.Report;
import com.xjtuse.drug_management.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;


    @Override
    public void insert(Report report) {
        reportMapper.insert(report);
    }
}
