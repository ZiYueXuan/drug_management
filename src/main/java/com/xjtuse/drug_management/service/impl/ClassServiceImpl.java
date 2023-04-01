package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ClassMapper;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;

    @Override
    public List<Class> getAll() {
        return classMapper.getAll();
    }

    @Override
    public Class getClassById(int classId) {
        return classMapper.getClassById(classId);
    }

    @Override
    public void add(Class c) {
        classMapper.insert(c);
    }
}
