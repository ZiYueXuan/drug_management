package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InspectorExamineMapper {

    @Insert("INSERT INTO `inspector_examine`(`report_id`,`status`,`opinion`,`time`,`controller_id`) " +
            "VALUES (#{report.id},#{status},#{opinion},#{time},#{controller.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(InspectorExamine inspectorExamine);

    @Select("SELECT * FROM `inspector_examine` WHERE " +
            "`controller_id` = #{controllerId} AND `status` = ${通过审核}")
    List<InspectorExamine> getExaminedReports(int controllerId);

}
