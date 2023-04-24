package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Apply;
import com.xjtuse.drug_management.domain.pojo.Drug;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyMapper {
    @Insert("INSERT INTO `apply`(`researcher_id`,`drug_id`,`time`,`number`,`status`)" +
            "VALUES (#{researcher.id},#{drug.id},#{time},#{number},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Apply apply);

    @Select("SELECT * FROM `apply` WHERE `researcher_id` = #{researcherId}")
    @Results(id = "applyMap", value = {
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
    List<Apply> getAppliesWithResearcher(int researcherId);

    @Select("SELECT * FROM `apply` WHERE `researcher_id` = #{researcherId} AND `status` = #{status} ")
    @ResultMap("applyMap")
    List<Apply> getAppliesWithResearcherAndStatus(int researcherId, int status);

    @Select("SELECT * FROM `apply` WHERE `status` = ${1}")
    @ResultMap("applyMap")
    List<Apply> getApplies();

    @Update("UPDATE `apply` SET `status` = #{status} WHERE `id` = #{apply.id}")
    void updateStatus(Apply apply, int status);
}
