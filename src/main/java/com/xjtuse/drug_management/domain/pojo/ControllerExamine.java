package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControllerExamine {
    private int id;
    private Report report;
    private String status;
    private String opinion;
    private Date time;
    private Controller controller;
}
