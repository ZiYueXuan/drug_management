package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Drug;

import java.util.List;

public interface DrugService {
    List<Drug> getDrugByClass(int classId);

    Drug getDrugById(int drugId);
}
