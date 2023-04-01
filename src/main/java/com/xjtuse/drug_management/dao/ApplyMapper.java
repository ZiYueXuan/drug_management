package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Apply;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyMapper {
    @Insert("INSERT INTO `apply`(`researcher_id`,`drug_id`,`number`,`status`)" +
            "VALUES (#{researcher.id},#{drug.id},#{number},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Apply apply);

    @Select("SELECT * FROM `apply`")
    @Results(id = "applyMapper", value = {
            @Result(property = "researcher",
                    column = "researcher_id",
                    javaType = Researcher.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ResearcherMapper.getResearcherById")
            ),
            @Result(property = "drug",
                    column = "drug_id",
                    javaType = Drug.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.DrugMapper.getDrugById")
            )
    })
    List<Apply> getApplies();

    @Select("SELECT * FROM `apply` WHERE `status` = #{status} ")
    List<Apply> getApplies(int status);
}
