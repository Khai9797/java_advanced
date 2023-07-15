package com.vti.testing.validate.account;

import com.vti.testing.validate.department.DepartmentNameExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartmentNameExistsValidator.class)
public @interface AccountNameNotExists {
    String message() default "User name existed";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
