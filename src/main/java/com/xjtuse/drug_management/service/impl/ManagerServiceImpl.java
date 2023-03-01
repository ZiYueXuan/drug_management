package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ManagerMapper;
import com.xjtuse.drug_management.domain.pojo.Manager;
import com.xjtuse.drug_management.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager getManagerByPhone(String phone) {
        return managerMapper.getManagerByPhone(phone);
    }

    @Override
    public Manager getManagerByMail(String mail) {
        return managerMapper.getManagerByMail(mail);
    }
}
