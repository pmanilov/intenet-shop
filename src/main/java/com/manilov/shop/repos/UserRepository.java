package com.manilov.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manilov.shop.domain.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
