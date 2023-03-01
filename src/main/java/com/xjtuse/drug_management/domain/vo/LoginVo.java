package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {
    private int identity;
    private int way;
    private String phone;
    private String mail;
    private String password;
}
