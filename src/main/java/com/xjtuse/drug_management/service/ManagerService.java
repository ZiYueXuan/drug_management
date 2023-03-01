package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Manager;

public interface ManagerService {
    Manager getManagerByPhone(String phone);

    Manager getManagerByMail(String mail);
}
