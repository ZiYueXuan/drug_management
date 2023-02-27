package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Classify;
import com.xjtuse.drug_management.domain.pojo.Drug;

import java.util.List;

public interface InitService {
    void initClass(Class c);
    Class getClassByName(String name);
    void initClassify(Classify classify);
    List<Classify> getClassifyByClassId(long classId);
    void initDrug(Drug drug);
}
