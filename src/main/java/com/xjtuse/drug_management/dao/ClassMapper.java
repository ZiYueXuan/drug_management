package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassMapper {

    @Insert("INSERT INTO `class`(`name`) VALUES (#{name}) ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Class c);

    @Select("SELECT * FROM `class` WHERE name = #{name}")
    Class getClassByName(String name);

    @Select("SELECT * FROM `class` WHERE id = #{id}")
    Class getClassById(long id);
}
