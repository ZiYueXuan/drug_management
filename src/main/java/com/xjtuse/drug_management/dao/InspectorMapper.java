package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Inspector;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InspectorMapper {
    @Select("SELECT * FROM `inspector` WHERE `phone` = #{phone}")
    Inspector getInspectorByPhone(String phone);

    @Select("SELECT * FROM `inspector` WHERE `mail` = #{mail}")
    Inspector getInspectorByMail(String mail);

    @Insert("INSERT INTO `inspector`(`name`,`password`,`phone`,`mail`)" +
            "VALUES(#{name},#{password},#{phone},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Inspector inspector);

    @Select("SELECT * FROM `inspector` WHERE `id` = #{id}")
    Inspector getInspectorById(int id);
}
