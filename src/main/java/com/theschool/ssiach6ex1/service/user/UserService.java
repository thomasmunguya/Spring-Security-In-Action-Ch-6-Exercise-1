package com.theschool.ssiach6ex1.service.user;

import com.theschool.ssiach6ex1.model.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Represents a type that is responsible for business logic pertaining to users.
 *
 * @author Thomas Munguya
 */
public interface UserService extends UserDetailsService {

    /**
     * Creates a new user.
     * @param user the user to add.
     * @throws IllegalArgumentException if {@code user} is null.
     */
    void createUser(User user);

    /**
     * Updates an existing user.
     * @param user the user to update.
     * @throws IllegalArgumentException if {@code user} is null.
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException if the username associated with
     * {@code user} does not exist.
     */
    void updateUser(User user);

    /**
     * Deletes a user by their username.
     * @param username the username of the user to delete.
     * @throws IllegalArgumentException if {@code username} is null.
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException if the user with {@code username}
     * does not exist.
     */
    void deleteUserByUsername(String username);
}
