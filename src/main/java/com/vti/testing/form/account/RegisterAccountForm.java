package com.vti.testing.form.account;

import com.vti.testing.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterAccountForm {
    private String username;
    private String password ;
    private String firstName;
    private String lastName;
    private Role role;
    private String departmentName;
}
