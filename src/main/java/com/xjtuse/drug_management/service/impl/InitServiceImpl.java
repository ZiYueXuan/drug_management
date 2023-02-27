package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ClassMapper;
import com.xjtuse.drug_management.dao.ClassifyMapper;
import com.xjtuse.drug_management.dao.DrugMapper;
import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Classify;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private ClassifyMapper classifyMapper;
    @Resource
    private DrugMapper drugMapper;

    @Override
    public void initClass(Class c) {
        classMapper.insert(c);
    }

    @Override
    public Class getClassByName(String name) {
        return classMapper.getClassByName(name);
    }

    @Override
    public void initClassify(Classify classify) {
        classifyMapper.insert(classify);
    }

    @Override
    public List<Classify> getClassifyByClassId(long classId) {
        return classifyMapper.getClassifyByClassId(classId);
    }

    @Override
    public void initDrug(Drug drug) {
        drugMapper.insert(drug);
    }
}
