package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apply {
    private int id;
    private Researcher researcher;
    private Drug drug;
    private Date time;
    private int number;
    private int status;
}
