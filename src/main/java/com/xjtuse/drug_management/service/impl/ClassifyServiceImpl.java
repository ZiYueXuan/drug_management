package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ClassifyMapper;
import com.xjtuse.drug_management.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;


}
