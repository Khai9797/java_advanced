package com.vti.testing.form.account;

import com.vti.testing.entity.Department;
import com.vti.testing.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFilterForm {
    private String search;
    private Role role;
    private String department;

}
