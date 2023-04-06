package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Inspector;

public interface InspectorService {
    Inspector getInspectorByPhone(String phone);

    Inspector getInspectorByMail(String mail);

    void insert(Inspector inspector);

    Inspector getInspectorById(int inspector_id);
}
