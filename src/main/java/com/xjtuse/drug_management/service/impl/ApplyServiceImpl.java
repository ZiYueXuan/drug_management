package com.xjtuse.drug_management.service.impl;

import com.xjtuse.drug_management.dao.ApplyMapper;
import com.xjtuse.drug_management.domain.pojo.Apply;
import com.xjtuse.drug_management.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;

    @Override
    public void insert(Apply apply) {
        applyMapper.insert(apply);
    }

    @Override
    public List<Apply> getApplies(int researcherId) {
        return applyMapper.getApplies(researcherId);
    }

    @Override
    public List<Apply> getApplies(int researcherId, int status) {
        return applyMapper.getApplies(researcherId, status);
    }

    @Override
    public List<Apply> getApplies() {
        return applyMapper.getApplies();
    }

    @Override
    public void updateStatus(Apply apply, int status) {
        applyMapper.updateStatus(apply, status);
    }
}
