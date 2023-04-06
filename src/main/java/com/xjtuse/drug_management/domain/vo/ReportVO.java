package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
    private int researcher_id;
    private int inspector_id;
    private String title;
    private String content;
    private Date time;
    private String appendix;
}
