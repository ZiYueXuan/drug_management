package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface InspectorExamineMapper {

    @Insert("INSERT INTO `inspector_examine`(`report_id`,`status`,`opinion`,`time`,`controller_id`) " +
            "VALUES (#{report.id},#{status},#{opinion},#{time},#{controller.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(InspectorExamine inspectorExamine);
}
