package com.vti.testing.form.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class UpdateDepartmentForm {
    private int id;
    private String name;
    private int totalMember;
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
}
