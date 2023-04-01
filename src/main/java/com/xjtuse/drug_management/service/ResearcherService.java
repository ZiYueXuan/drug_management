package com.xjtuse.drug_management.service;

import com.xjtuse.drug_management.domain.pojo.Researcher;

public interface ResearcherService {
    Researcher getResearcherByPhone(String phone);

    Researcher getResearcherByMail(String mail);

    void insert(Researcher researcher);

    Researcher getResearcherById(int researcherId);
}
