package com.ilyas.api_bancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilyas.api_bancaire.entity.accounts;
@Repository

public interface AccountRepository extends JpaRepository<accounts, Long> {

     accounts findTopByOrderByAccountIdDesc();

}
