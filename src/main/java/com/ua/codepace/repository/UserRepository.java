package com.ua.codepace.repository;

import com.ua.codepace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
