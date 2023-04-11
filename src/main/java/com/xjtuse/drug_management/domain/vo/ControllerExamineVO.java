package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControllerExamineVO {
    private int reportId;
    private String status;
    private String opinion;
    private Date time;
    private int controllerId;
}
