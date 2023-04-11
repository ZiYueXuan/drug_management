package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ControllerExamineMapper;
import com.xjtuse.drug_management.dao.ControllerMapper;
import com.xjtuse.drug_management.dao.InspectorExamineMapper;
import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.ControllerExamine;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import com.xjtuse.drug_management.service.ControllerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ControllerServiceImpl implements ControllerService {
    @Resource
    private ControllerMapper controllerMapper;
    @Resource
    private InspectorExamineMapper inspectorExamineMapper;
    @Resource
    private ControllerExamineMapper controllerExamineMapper;

    @Override
    public Controller getControllerByPhone(String phone) {
        return controllerMapper.getControllerByPhone(phone);
    }

    @Override
    public Controller getControllerByMail(String mail) {
        return controllerMapper.getControllerByMail(mail);
    }

    @Override
    public Controller getControllerById(int controllerId) {
        return controllerMapper.getControllerById(controllerId);
    }

    @Override
    public List<Controller> getControllers() {
        return controllerMapper.getControllers();
    }

    @Override
    public List<InspectorExamine> getExaminedReports(int controllerId) {
        return inspectorExamineMapper.getExaminedReports(controllerId);
    }

    @Override
    public void examine(ControllerExamine controllerExamine) {
        controllerExamineMapper.insert(controllerExamine);
    }

    @Override
    public void insert(Controller controller) {
        controllerMapper.insert(controller);
    }
}
