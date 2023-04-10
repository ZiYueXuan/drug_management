package com.xjtuse.drug_management.dao;

import com.xjtuse.drug_management.domain.pojo.Controller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ControllerMapper {
    @Select("SELECT * FROM `controller` WHERE `phone` = #{phone}")
    Controller getControllerByPhone(String phone);

    @Select("SELECT * FROM `controller` WHERE `mail` = #{mail}")
    Controller getControllerByMail(String mail);

    @Insert("INSERT INTO `controller`(`name`,`password`,`phone`,`mail`)" +
            "VALUES(#{name},#{password},#{phone},#{mail})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Controller controller);

    @Select("SELECT * FROM `controller` WHERE `id` = #{controllerId}")
    Controller getControllerById(int controllerId);
}
