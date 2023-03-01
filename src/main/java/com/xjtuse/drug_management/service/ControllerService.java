package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Controller;

public interface ControllerService {
    Controller getControllerByPhone(String phone);

    Controller getControllerByMail(String mail);
}
