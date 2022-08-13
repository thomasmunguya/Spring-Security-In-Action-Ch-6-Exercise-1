package com.theschool.ssiach6ex1.repository.authority;

import com.theschool.ssiach6ex1.model.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The {@code AuthorityRepository} interface represents a type is responsible for handling
 * persistence logic pertaining to authorities.
 *
 * @author Thomas Munguya
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
