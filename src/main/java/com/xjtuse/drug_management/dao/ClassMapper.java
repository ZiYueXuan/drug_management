package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ClassMapper {

    @Insert("INSERT INTO `class`(`name`) VALUES (#{name}) ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Class c);
}
