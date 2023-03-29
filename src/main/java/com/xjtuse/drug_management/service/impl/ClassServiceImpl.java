package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ClassMapper;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.service.ClassService;

import javax.annotation.Resource;
import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;

    @Override
    public List<Class> getAll() {
        return classMapper.getAll();
    }
}
