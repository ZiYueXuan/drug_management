package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Researcher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ResearcherMapper {
    @Select("SELECT * FROM `researcher` WHERE `phone` = #{phone}")
    Researcher getResearcherByPhone(String phone);

    @Select("SELECT * FROM `researcher` WHERE `mail` = #{mail}")
    Researcher getResearcherByMail(String mail);
}
