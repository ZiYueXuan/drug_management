package com.xjtuse.drug_management.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private int identity;
    private int way;
    private String phone;
    private String mail;
    private String verificationCode;
    private String password;
}
