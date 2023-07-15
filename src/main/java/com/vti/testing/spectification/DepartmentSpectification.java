package com.vti.testing.spectification;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.form.account.AccountFilterForm;
import com.vti.testing.form.department.DepartmentFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class DepartmentSpectification {
    private static final String DEPARTMENTNAME = "name";
    private static final String MIN_CREATEDATE = "minCreatedDate";
    private static final String MAX_CREATEDATE = "maxCreatedDate";
    private static final String TYPE = "type";

    public static Specification<Department> buidWhere(DepartmentFilterForm form) {
        if (form == null) {
            return null;
        }
        Specification whereDepartmentName = new DepartmentSpectification.CustomSpecification(DEPARTMENTNAME, form.getSearch());
        Specification whereMinCreateDate = new DepartmentSpectification.CustomSpecification(MIN_CREATEDATE, form.getMinCreatedDate());
        Specification whereMaxCreatedDate = new DepartmentSpectification.CustomSpecification(MAX_CREATEDATE, form.getMaxCreatedDate());
        Specification whereType = new DepartmentSpectification.CustomSpecification(TYPE, form.getType());
        return Specification.where((whereDepartmentName).and((whereMinCreateDate).and(whereMaxCreatedDate)).or(whereType));
    }

    @AllArgsConstructor
    static class CustomSpecification implements Specification<Department> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (value == null) {
                return null;
            }
            switch (key) {
                case DEPARTMENTNAME:
                    return criteriaBuilder.like(root.get("name"), "%" + value + "%");
                case MIN_CREATEDATE:
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class),(Date)value);
                case MAX_CREATEDATE:
                    return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class),(Date)value);
                case TYPE:
                    return criteriaBuilder.equal(root.get("type"),  value );
            }
            return null;
        }
    }
}
