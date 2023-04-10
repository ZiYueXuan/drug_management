package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.InspectorExamineMapper;
import com.xjtuse.drug_management.dao.InspectorMapper;
import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import com.xjtuse.drug_management.service.InspectorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspectorServiceImpl implements InspectorService {
    @Resource
    private InspectorMapper inspectorMapper;
    @Resource
    private InspectorExamineMapper inspectorExamineMapper;

    @Override
    public Inspector getInspectorByPhone(String phone) {
        return inspectorMapper.getInspectorByPhone(phone);
    }

    @Override
    public Inspector getInspectorByMail(String mail) {
        return inspectorMapper.getInspectorByMail(mail);
    }

    @Override
    public void insert(Inspector inspector) {
        inspectorMapper.insert(inspector);
    }

    @Override
    public Inspector getInspectorById(int inspector_id) {
        return inspectorMapper.getInspectorById(inspector_id);
    }

    @Override
    public List<Inspector> getInspectors() {
        return inspectorMapper.getInspectors();
    }

    @Override
    public void examine(InspectorExamine inspectorExamine) {
        inspectorExamineMapper.insert(inspectorExamine);
    }

}
