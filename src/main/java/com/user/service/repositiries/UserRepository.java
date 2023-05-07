package com.user.service.repositiries;

import com.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserId(final String userId);

    void deleteByUserId(final String userId);
}
