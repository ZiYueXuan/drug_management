package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Classify;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassifyMapper {

    @Insert("INSERT INTO `classify`(`class_id`,`name`,`classifyId`) " +
            "VALUES (#{c.id},#{name},#{classifyId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Classify classify);

    @Select("SELECT * FROM `classify` WHERE `class_id` = #{classId}")
    @Results(id = "classifyMapper", value = {
            @Result(property = "c",
                    column = "class_id",
                    javaType = Class.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ClassMapper.getClassById")
            )
    })
    List<Classify> getClassifyByClassId(long classId);
}
