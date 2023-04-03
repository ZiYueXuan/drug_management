package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.DrugMapper;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
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

    @Override
    public void updateNumber(Drug drug, int number) {
        drugMapper.updateNumber(drug, number);
    }
}
