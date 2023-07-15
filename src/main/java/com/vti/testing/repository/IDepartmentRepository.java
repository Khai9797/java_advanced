package com.vti.testing.repository;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
    Department getByName(String departmentName);
    boolean existsByName(String name);
}
