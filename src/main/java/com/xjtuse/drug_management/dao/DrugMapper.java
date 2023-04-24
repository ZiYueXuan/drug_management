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

    @Select("SELECT * FROM `drug` WHERE `id` = #{drugId}")
    @Results(id = "drugMap", value = {
            @Result(property = "c",
                    column = "class_id",
                    javaType = Class.class,
                    one = @One(select = "com.xjtuse.drug_management.dao.ClassMapper.getClassById")
            )
    })
    Drug getDrugById(int drugId);

    @Select("SELECT * FROM `drug` WHERE `classId` = #{classId}")
    @ResultMap("drugMap")
    List<Drug> getDrugsByClass(int classId);

    @Update("UPDATE `drug` SET `number` = `number` - #{number}  WHERE  `id` = #{drug.id}")
    void updateNumber(Drug drug, int number);
}
