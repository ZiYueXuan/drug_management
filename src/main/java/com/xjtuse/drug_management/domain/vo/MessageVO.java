package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
    private long id;
    private String name;
    private String result;
}
