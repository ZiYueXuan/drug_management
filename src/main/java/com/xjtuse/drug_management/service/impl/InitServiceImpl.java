package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ClassMapper;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public void initClass(Class c) {
        classMapper.insert(c);
    }
}
