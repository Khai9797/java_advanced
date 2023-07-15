package com.vti.testing.spectification;

import com.vti.testing.entity.Account;
import com.vti.testing.form.account.AccountFilterForm;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpectification {
    @Autowired
    private ModelMapper modelMapper;
    private static final String USERNAME = "username";
    private static final String DEPARTMENT = "department";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String ROLE = "role";

    public static Specification<Account> buidWhere(AccountFilterForm form) {
        if (form == null) {
            return null;
        }
        Specification whereUsername = new CustomSpecification(USERNAME, form.getSearch());
        Specification whereDepartment = new CustomSpecification(DEPARTMENT, form.getDepartment());
        Specification whereRole = new CustomSpecification(ROLE, form.getRole());
        Specification wherefirstName = new CustomSpecification(FIRST_NAME, form.getSearch());
        Specification wherelastName = new CustomSpecification(LAST_NAME, form.getSearch());


        return Specification.where(whereUsername.or(wherefirstName).or(wherelastName)).or(whereDepartment.or(whereRole));
    }

    @AllArgsConstructor
    static class CustomSpecification implements Specification<Account> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case USERNAME:
                    // where username like %value%
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
                case DEPARTMENT:
                    // where username like %value%
                    return criteriaBuilder.like(root.get("department").get("name"), "%" + value + "%");
                case ROLE:
                    // Where id >= value
                    return criteriaBuilder.equal(root.get("role"),  value);
                case FIRST_NAME:
                    // Where id <= value
                    return criteriaBuilder.like(root.get("firstName"), "%" + value + "%");
                case LAST_NAME:
                    // Where id <= value
                    return criteriaBuilder.like(root.get("lastName"), "%" + value + "%");
            }
            return null;
        }
    }
}
