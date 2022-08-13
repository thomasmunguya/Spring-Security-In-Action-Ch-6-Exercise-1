package com.theschool.ssiach6ex1.repository.user;

import com.theschool.ssiach6ex1.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The {@code UserRepository} interface represents a type is responsible for handling
 * persistence logic pertaining to users.
 *
 * @author Thomas Munguya
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
