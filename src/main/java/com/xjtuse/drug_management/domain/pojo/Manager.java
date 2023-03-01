package com.xjtuse.drug_management.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private int id;
    private String name;
    private String password;
    private String phone;
    private String mail;
}
