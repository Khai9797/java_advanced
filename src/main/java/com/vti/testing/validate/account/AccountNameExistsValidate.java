package com.vti.testing.validate.account;

import com.vti.testing.repository.IAccountRepository;
import com.vti.testing.service.IAccountService;
import com.vti.testing.validate.department.DepartmentNameNotExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNameExistsValidate implements ConstraintValidator<AccountNameNotExists, String> {
    @Autowired
    IAccountService accountService;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !accountService.isAccountNameExists(username);
    }
}
