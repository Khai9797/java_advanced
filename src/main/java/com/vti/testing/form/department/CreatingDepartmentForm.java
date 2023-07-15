package com.vti.testing.form.department;

import com.vti.testing.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import java.util.List;
@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
    private String name;
    private int totalMember;
    private String type;
    private List<@Valid Account> accounts;
    @Data
    @NoArgsConstructor
    public static class Account {

        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private Role role;
    }
}
