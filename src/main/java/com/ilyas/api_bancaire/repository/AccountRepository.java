package com.ilyas.api_bancaire.repository;

import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilyas.api_bancaire.entity.accounts;

import java.util.List;

@Repository

public interface AccountRepository extends JpaRepository<accounts, Long> {

     accounts findTopByOrderByAccountIdDesc();
     List<accounts> findAccountByuserId(Long id);
}
