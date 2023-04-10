package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectorExamineVO {
    private int reportId;
    private int controllerId;
    private String status;
    private String opinion;
    private Date time;
}
