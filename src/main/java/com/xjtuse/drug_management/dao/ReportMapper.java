package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ReportMapper {
    @Insert("INSERT INTO `report`(`researcxher_id`,`title`,`content`,`time`,`appendix`,`inspector_id`) " +
            "VALUES (#{researcher.id},#{title},#{content},#{time},#{appendix},#(inspector.id))")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Report report);
}
