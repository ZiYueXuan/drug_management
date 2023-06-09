package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private int id;
    private Researcher researcher;
    private String title;
    private String content;
    private Timestamp time;
    private String appendix;
    private Inspector inspector;
}
