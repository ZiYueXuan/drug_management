package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ControllerMapper;
import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.service.ControllerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ControllerServiceImpl implements ControllerService {
    @Resource
    private ControllerMapper controllerMapper;

    @Override
    public Controller getControllerByPhone(String phone) {
        return controllerMapper.getControllerByPhone(phone);
    }

    @Override
    public Controller getControllerByMail(String mail) {
        return controllerMapper.getControllerByMail(mail);
    }
}
