package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.InspectorExamine;
import com.xjtuse.drug_management.domain.pojo.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InspectorExamineMapper {

    @Insert("INSERT INTO `inspector_examine`(`report_id`,`status`,`opinion`,`time`,`controller_id`) " +
            "VALUES (#{report.id},#{status},#{opinion},#{time},#{controller.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(InspectorExamine inspectorExamine);

    @Select("SELECT * FROM `inspector_examine` WHERE " +
            "`controller_id` = #{controllerId} AND `status` = ${通过审核}")
    @Results(id = "examineMapper1", value = {
            @Result(property = "report",
                    column = "report_id",
                    javaType = Report.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ReportMapper.getReportById")
            ),
            @Result(property = "controller",
                    column = "controller_id",
                    javaType = Controller.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ControllerMapper.getControllerById")
            )
    })
    List<InspectorExamine> getExaminedReports(int controllerId);

}
