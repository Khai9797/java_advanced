package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.form.account.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService {
    Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form);

    Account getAccountById(int id);

    void createAccount(CreatingAccountForm form);

    void updateAccount(UpdateAccountForm form);
    void deleteAccount(List<Integer> ids);
    public boolean isAccountIdExists(int id);
    public boolean isAccountNameExists(String username);

    Account getAccountByUsername(String username);
}
