package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ResearcherMapper;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import com.xjtuse.drug_management.service.ResearcherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResearcherServiceImpl implements ResearcherService {
    @Resource
    private ResearcherMapper researcherMapper;

    @Override
    public Researcher getResearcherByPhone(String phone) {
        return researcherMapper.getResearcherByPhone(phone);
    }

    @Override
    public Researcher getResearcherByMail(String mail) {
        return researcherMapper.getResearcherByMail(mail);
    }
}
