package com.xjtuse.drug_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DrugManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugManagementApplication.class, args);
    }

}
