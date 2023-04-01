package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Class;
import com.xjtuse.drug_management.domain.pojo.Drug;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugMapper {
    @Insert("INSERT INTO `drug`(`name`,`classId`,`drugId`,`specification`,`form`" +
            ",`approvalNumber`,`executiveStandard`,`producer`,`indication`" +
            ",`component`,`interact`,`properties`,`number`,`price`,`validityTime`" +
            ",`usageConsumption`,`taboo`,`adverseReaction`,`storeUp`,`matters`) " +
            "VALUES(#{name},#{c.id},#{drugId},#{specification},#{form},#{approvalNumber}," +
            "#{executiveStandard},#{producer},#{indication},#{component},#{interact}," +
            "#{properties},#{number},#{price},#{validityTime},#{usageConsumption}," +
            "#{taboo},#{adverseReaction},#{storeUp},#{matters}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Drug drug);

    @Select("SELECT * FROM `Drug` WHERE `classId` = #{classId}")
    @Results(id = "drugMapper", value = {
            @Result(property = "c",
                    column = "classId",
                    javaType = Class.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ClassMapper.getClassById")
            )
    })
    List<Drug> getDrugsByClass(int classId);
}
