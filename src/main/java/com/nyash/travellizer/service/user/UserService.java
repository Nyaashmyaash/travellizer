package com.nyash.travellizer.service.user;

import com.nyash.travellizer.model.entity.user.User;

import java.util.List;
import java.util.Optional;

/**
 * Provides API for the user management
 * @author Nyash
 *
 */
public interface UserService {

    /**
     * Saves(creates or modifies) specified user instance
     * @param user
     */
    void save(User user);

    /**
     * Returns user with specified identifier boxed into Optional
     * @param userId
     * @return
     */
    Optional<User> findById(int userId);

    /**
     * Returns user with specified username
     * @param userName
     * @return
     */
    Optional<User> findByUserName (String userName);

    /**
     * Delete user with specified identifier
     * @param userId
     */
    void delete(int userId);

    /**
     * Returns all users
     * @return
     */
    List<User> findAll();
}
