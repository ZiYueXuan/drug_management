package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Controller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface ControllerMapper {
    @Select("SELECT * FROM `controller` WHERE `phone` = #{phone}")
    public Controller getControllerByPhone(String phone);

    @Select("SELECT * FROM `controller` WHERE `mail` = #{mail}")
    public Controller getControllerByMail(String mail);

    @Insert("INSERT INTO `controller`(`name`,`password`,`phone`,`mail`)" +
            "VALUES(#{name},#{password},#{phone},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Controller controller);
}
