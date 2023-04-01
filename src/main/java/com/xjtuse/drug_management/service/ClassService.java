package com.xjtuse.drug_management.service;


import com.xjtuse.drug_management.domain.pojo.Class;

import java.util.List;

public interface ClassService {
    List<Class> getAll();

    Class getClassById(int classId);

    void add(Class c);
}
