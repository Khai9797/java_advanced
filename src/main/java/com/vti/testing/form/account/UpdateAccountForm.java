package com.vti.testing.form.account;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class UpdateAccountForm {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private Role role;
    private String departmentName;
}
