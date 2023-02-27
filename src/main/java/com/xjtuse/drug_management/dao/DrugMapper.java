package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Drug;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface DrugMapper {
    @Insert("INSERT INTO `drug`(`name`,`drugId`,`specification`,`form`" +
            ",`approvalNumber`,`executiveStandard`,`producer`,`indication`" +
            ",`component`,`interact`,`properties`,`number`,`price`,`validityTime`" +
            ",`usageConsumption`,`taboo`,`adverseReaction`,`storeUp`,`matters`) " +
            "VALUES(#{name},#{drugId},#{specification},#{form},#{approvalNumber}," +
            "#{executiveStandard},#{producer},#{indication},#{component},#{interact}," +
            "#{properties},#{number},#{price},#{validityTime},#{usageConsumption}," +
            "#{taboo},#{adverseReaction},#{storeUp},#{matters}) ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Drug drug);
}
