package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    private long id;
    private String name;
    private String approvalNumber;
    private Classify classify;
    private String producer;
    private String indication;
    private String component;
    private int number;
    private Date manufactureDate;
    private Date validityTime;
    private String usage;
    private String consumption;
    private String taboo;
    private String adverseReaction;
    private String graph;
}
