package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.ControllerExamine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ControllerExamineMapper {
    @Insert("INSERT INTO `controller_examine`(`report_id`,`status`,`opinion`,`time`,`controller_id`) " +
            "VALUES (#{report.id},#{status},#{opinion},#{time},#{controller.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ControllerExamine controllerExamine);
}
