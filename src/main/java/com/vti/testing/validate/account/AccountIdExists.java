package com.vti.testing.validate.account;

import com.vti.testing.validate.department.DepartmentIdExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartmentIdExistsValidator.class)
public @interface AccountIdExists {
    String message() default "Account id not exists";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
