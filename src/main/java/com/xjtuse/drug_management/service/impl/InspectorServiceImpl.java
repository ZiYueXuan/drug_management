package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.InspectorMapper;
import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.service.InspectorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InspectorServiceImpl implements InspectorService {
    @Resource
    private InspectorMapper inspectorMapper;

    @Override
    public Inspector getInspectorByPhone(String phone) {
        return inspectorMapper.getInspectorByPhone(phone);
    }

    @Override
    public Inspector getInspectorByMail(String mail) {
        return inspectorMapper.getInspectorByMail(mail);
    }
}
