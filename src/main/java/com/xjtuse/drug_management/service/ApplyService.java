package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Apply;

import java.util.List;

public interface ApplyService {
    void insert(Apply apply);

    List<Apply> getApplies(int researcherId);

    List<Apply> getApplies(int researcherId, int status);

    List<Apply> getApplies();

    void updateStatus(Apply apply);
}
