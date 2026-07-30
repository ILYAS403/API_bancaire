package com.ilyas.api_bancaire.repository;

import com.ilyas.api_bancaire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User  findByEmailAndPassword(String email, String password);


}