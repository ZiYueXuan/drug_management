package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.ControllerExamine;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;

import java.util.List;

public interface ControllerService {
    Controller getControllerByPhone(String phone);

    Controller getControllerByMail(String mail);

    void insert(Controller controller);

    Controller getControllerById(int controllerId);

    List<Controller> getControllers();

    List<InspectorExamine> getExaminedReports(int controllerId);

    void examine(ControllerExamine controllerExamine);
}
