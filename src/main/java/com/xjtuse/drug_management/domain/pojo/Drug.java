package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    private long id;//主键
    private String name;//药物名称
    private String drugId;//药品ID
    private String specification;//规格
    private String form;//剂型
    private String approvalNumber;//药物批准编号
    private String executiveStandard;//执行标准
    private String producer;//药物生产厂家
    private String indication;//药物适应症
    private String component;//药物主要成分
    private String interact;//药物相互作用
    private String properties;//性状
    private int number;//药物数量
    private float price;//建议价格
    private String validityTime;//药物有效期
    private String usageConsumption;//用法用量
    private String taboo;//禁忌
    private String adverseReaction;//不良反应
    private String storeUp;//贮藏
    private String matters;//注意事项
}
