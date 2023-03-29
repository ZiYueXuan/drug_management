package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.service.ClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RepositoryController {
    @Resource
    private ClassService classService;

    @RequestMapping("/manager/addRepository")
    public List<Class> addRepository() {
        return classService.getAll();
    }
}
