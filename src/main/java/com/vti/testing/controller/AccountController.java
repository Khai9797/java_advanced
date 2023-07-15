package com.vti.testing.controller;

import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.form.account.AccountFilterForm;
import com.vti.testing.form.account.CreatingAccountForm;
import com.vti.testing.form.account.DeleteAccountForm;
import com.vti.testing.form.account.UpdateAccountForm;
import com.vti.testing.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/accounts")
@CrossOrigin(value = "*")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Page<AccountDTO> getAllAccounts(Pageable pageable, AccountFilterForm form) {
        Page<Account> accountsPage = accountService.getAllAccounts(pageable, form);
        List<Account> accounts = accountsPage.getContent();
        List<AccountDTO> accountDTOS = modelMapper.map(accounts, new TypeToken<List<AccountDTO>>() {
        }.getType());
        return new PageImpl<>(accountDTOS, pageable, accountsPage.getTotalElements());
    }

    @GetMapping(value = "/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public AccountDTO getAccountById(@PathVariable(name = "id") int id) {
        Account account = accountService.getAccountById(id);
        return modelMapper.map(account, AccountDTO.class);
    }

    @PostMapping
    public void createAccount(@RequestBody CreatingAccountForm form) {
        accountService.createAccount(form);
    }

    @PutMapping(value = "/{id}")
    public void updateAccount(@PathVariable(name = "id") int id, @RequestBody UpdateAccountForm form) {
        form.setId(id);
        accountService.updateAccount(form);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccountbyId(@RequestBody DeleteAccountForm form) {
        List<Integer> ids = form.getIds();
        accountService.deleteAccount(ids);
    }


}
