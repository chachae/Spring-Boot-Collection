package com.chachae.repository;

import com.chachae.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chachae
 * @since 2020/1/7 23:07
 */
@Repository("userDAO")
public interface UserDAO extends JpaRepository<User, Long> {}
