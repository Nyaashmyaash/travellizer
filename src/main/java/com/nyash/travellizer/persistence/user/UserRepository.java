package com.nyash.travellizer.persistence.user;

import com.nyash.travellizer.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Defines CRUD methods to access User objects in the persistent storage
 *
 * @author Nyash
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Returns user with specified username
     *
     * @param userName
     * @return
     */
    Optional<User> findByUserName(@Param("userName") String userName);
}
