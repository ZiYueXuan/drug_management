package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.DrugMapper;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.service.DrugService;

import javax.annotation.Resource;
import java.util.List;

public class DrugServiceImpl implements DrugService {
    @Resource
    private DrugMapper drugMapper;

    @Override
    public List<Drug> getDrugByClass(int classId) {
        return drugMapper.getDrugsByClass(classId);
    }

    @Override
    public Drug getDrugById(int drugId) {
        return drugMapper.getDrugById(drugId);
    }
}
