package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerMapper {
    @Select("SELECT * FROM `manager` WHERE `phone` = #{phone}")
    Manager getManagerByPhone(String phone);

    @Select("SELECT * FROM `manager` WHERE `mail` = #{mail}")
    Manager getManagerByMail(String mail);
}
