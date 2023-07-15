package com.vti.testing.dto;

import com.vti.testing.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
    private int id;
    private String username;
//    private String password;
    private String firstName;
    private String lastName;
    private String fullName;
    private String departmentName;
    private Role role;

}
