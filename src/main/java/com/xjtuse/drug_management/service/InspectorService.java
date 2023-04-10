package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;

import java.util.List;

public interface InspectorService {
    Inspector getInspectorByPhone(String phone);

    Inspector getInspectorByMail(String mail);

    void insert(Inspector inspector);

    Inspector getInspectorById(int inspector_id);

    List<Inspector> getInspectors();

    void examine(InspectorExamine inspectorExamine);
}
