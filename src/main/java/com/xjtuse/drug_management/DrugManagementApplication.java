package com.xjtuse.drug_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xjtuse.drug_management.dao")
public class DrugManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugManagementApplication.class, args);
    }

}
