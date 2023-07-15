package com.vti.testing.validate.account;

import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountIdExistsValidate implements ConstraintValidator<AccountIdExists, Integer> {
    @Autowired
    private IAccountService accountService;

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        return accountService.isAccountIdExists(id);
    }
}
