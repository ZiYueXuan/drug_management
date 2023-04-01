package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyVO {
    private int researcherId;
    private int drugId;
    private int number;
    // 1-已申请 2-已阅读 3-已发放
    private int status;
}
