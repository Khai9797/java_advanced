package com.vti.testing.controller;

import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Department;
import com.vti.testing.form.department.CreatingDepartmentForm;
import com.vti.testing.form.department.DeleteDepartmentFrom;
import com.vti.testing.form.department.DepartmentFilterForm;
import com.vti.testing.form.department.UpdateDepartmentForm;
import com.vti.testing.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/departments")
@CrossOrigin(value = "*")
public class DepartmentCotroller {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping
    public Page<DepartmentDTO> getAllDepartment(Pageable pageable,/* @RequestParam(name = "search", required = false) String search,*/ DepartmentFilterForm form){
        Page<Department> departmenstPage = departmentService.getAllDepartment(pageable,form);
        List<Department> departments = departmenstPage.getContent();
        List<DepartmentDTO> departmentDTOS = modelMapper.map(departments,new TypeToken<List<DepartmentDTO>>(){
        }.getType());
        return new PageImpl<>(departmentDTOS,pageable,departmenstPage.getTotalElements());
    }
    @PostMapping
    public void createDepartment(@RequestBody @Valid CreatingDepartmentForm form) {
        departmentService.createDepartment(form);
    }
    @PutMapping(value = "/{id}")
    public void updateDepartment(@PathVariable(name = "id")int id, @RequestBody UpdateDepartmentForm form){
        form.setId(id);
        departmentService.updateDepartment(form);
    }
    @DeleteMapping(value ="/{id}")
    public void deleteDepartmentbyID (DeleteDepartmentFrom from){
        departmentService.deleteDepartment(from);
    }
}
