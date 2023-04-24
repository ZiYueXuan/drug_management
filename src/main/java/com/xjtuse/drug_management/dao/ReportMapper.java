package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.domain.pojo.Report;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportMapper {
    @Insert("INSERT INTO `report`(`researcxher_id`,`title`,`content`,`time`,`appendix`,`inspector_id`) " +
            "VALUES (#{researcher.id},#{title},#{content},#{time},#{appendix},#(inspector.id))")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Report report);

    @Select("SELECT * FROM `report` WHERE `inspector_id` = #{inspectorId}")
    @Results(id = "reportMap", value = {
            @Result(property = "researcher",
                    column = "researcher_id",
                    javaType = Researcher.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ResearcherMapper.getResearcherById")
            ),
            @Result(property = "inspector",
                    column = "inspector_id",
                    javaType = Inspector.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.InspectorMapper.getInspectorById")
            )
    })
    List<Report> getReports(int inspectorId);

    @Select("SELECT * FROM `report` WHERE `id` = #{reportId}")
    @ResultMap("reportMap")
    Report getReportById(int reportId);
}
