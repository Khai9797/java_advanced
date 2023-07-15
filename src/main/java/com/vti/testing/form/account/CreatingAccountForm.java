package com.vti.testing.form.account;

import com.vti.testing.entity.Role;
import com.vti.testing.validate.account.AccountNameNotExists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

    private String username;
    private String password = "$2a$12$fRDcPl.uMebpbwi0d./Y0OJSmVhoJUCSy3EvO7mGaYcg/D1XF2RfS";
    private String firstName;
    private String lastName;
    private Role role;
    private String departmentName;
}
