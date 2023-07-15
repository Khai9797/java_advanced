package com.vti.testing.repository;

import com.vti.testing.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor {
    Account findById(int id);
//    boolean existsByName(String username);

    Account findByUsername(String username);
}
