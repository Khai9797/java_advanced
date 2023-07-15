package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.form.department.CreatingDepartmentForm;
import com.vti.testing.form.department.DeleteDepartmentFrom;
import com.vti.testing.form.department.DepartmentFilterForm;
import com.vti.testing.form.department.UpdateDepartmentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> getAllDepartment(Pageable pageable, DepartmentFilterForm form);
    void createDepartment(CreatingDepartmentForm form);
    void updateDepartment(UpdateDepartmentForm form);
    void deleteDepartment(DeleteDepartmentFrom form);
    boolean isDepartmentNameExists(String name);
    boolean isDepartmentIdExists(int id);



}
