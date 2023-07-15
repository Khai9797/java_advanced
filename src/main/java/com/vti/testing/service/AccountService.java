package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.form.account.AccountFilterForm;
import com.vti.testing.form.account.CreatingAccountForm;
import com.vti.testing.form.account.DeleteAccountForm;
import com.vti.testing.form.account.UpdateAccountForm;
import com.vti.testing.repository.IAccountRepository;
import com.vti.testing.repository.IDepartmentRepository;
import com.vti.testing.spectification.AccountSpectification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form) {

        Specification<Account> where = AccountSpectification.buidWhere(form);
        return accountRepository.findAll(where, pageable);
//        return accountRepository.findAll(pageable);
    }

    @Override
    public Account getAccountById(int id) {

        return accountRepository.findById(id);
    }

    @Override
    public void createAccount(CreatingAccountForm form) {
        TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class, Account.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        Department department = departmentRepository.getByName(form.getDepartmentName());
        Account account = modelMapper.map(form, Account.class);
        account.setDepartment(department);
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(UpdateAccountForm form) {
//        Account account = new Account();
//        account.setId(form.getId());
//        account.setUsername(form.getUsername());
//        account.setFirstName(form.getFirstName());
//        account.setLastName(form.getLastName());
//        account.setRole(form.getRole());
        Account account = accountRepository.findById(form.getId());
        Department department = departmentRepository.getByName(form.getDepartmentName());
//        account.setDepartment(department);
        modelMapper.map(form, account);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(List<Integer> ids) {
        for (Integer id : ids) {
            accountRepository.deleteById(id);
        }
    }
    public boolean isAccountIdExists(int id){
        return accountRepository.existsById(id);
    }

    @Override
    public boolean isAccountNameExists(String username) {
        return false;
//        return accountRepository.existsByName(username);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }


}
