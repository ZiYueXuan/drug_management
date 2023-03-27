package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo {
    private String name;
    private String phone;
    private String mail;
    private int identity;
    private String verificationCode;
    private String password;
}
