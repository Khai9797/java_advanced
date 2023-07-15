package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.form.department.CreatingDepartmentForm;
import com.vti.testing.form.department.DeleteDepartmentFrom;
import com.vti.testing.form.department.DepartmentFilterForm;
import com.vti.testing.form.department.UpdateDepartmentForm;
import com.vti.testing.repository.IAccountRepository;
import com.vti.testing.repository.IDepartmentRepository;
import com.vti.testing.spectification.AccountSpectification;
//import com.vti.testing.spectification.DepartmentSpectification;
import com.vti.testing.spectification.DepartmentSpectification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Override
    public Page<Department> getAllDepartment(Pageable pageable, DepartmentFilterForm form) {

        Specification<Department> where = DepartmentSpectification.buidWhere(form);
        return departmentRepository.findAll(where,pageable);
    }

    @Override
    public void createDepartment(CreatingDepartmentForm form) {
        Department department = modelMapper.map(form, Department.class);
        departmentRepository.save(department);
        List<Account> accounts = department.getAccounts();
        accounts.forEach(account -> account.setDepartment(department));
        accountRepository.saveAll(accounts);
    }

    @Override
    public void updateDepartment(UpdateDepartmentForm form) {
        Department department = modelMapper.map(form, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(DeleteDepartmentFrom form) {
        departmentRepository.deleteById(form.getId());
    }

    @Override
    public boolean isDepartmentNameExists(String name) {
        return departmentRepository.existsByName(name);
    }

    @Override
    public boolean isDepartmentIdExists(int id) {
        return departmentRepository.existsById(id);
    }
}
