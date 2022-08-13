package com.theschool.ssiach6ex1.model.authority;

import com.theschool.ssiach6ex1.model.user.User;
import javax.persistence.*;
import java.util.*;

/**
 * Represents and authority.
 *
 * @see com.theschool.ssiach6ex1.model.authority.AuthorityType
 * @author Thomas Munguya.
 */
@Entity
public class Authority {

    /**
     * Defines the identifier of the authority.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Defines the authority type.
     */
    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    /**
     * Returns the identifier of the authority.
     * @return the authority identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the authority type of the authority.
     * @return the authority type.
     */
    public AuthorityType getAuthority() {
        return authority;
    }

    /**
     * Sets the authority type.
     * @param authority the authority type.
     */
    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }

    /**
     * Returns the users having this authority.
     * @return the users having this authority.
     */
    public Set<User> getUsers() {
        return Set.copyOf(users);
    }

    /**
     * Sets the users having this authority.
     * @param users the users.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Determines if this authority is equal to {@code otherAuthority}.
     * @param otherAuthority the product to compare to this product.
     * @return {@code true} if this product is equal to {@code otherAuthority}.
     */
    @Override
    public boolean equals(Object otherAuthority) {
        if (this == otherAuthority) return true;
        if (!(otherAuthority instanceof Authority authority)) return false;
        return getId().equals(authority.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /**
     * Returns a {@code String} representation of this authority.
     * @return a {@code String} representation of this authority.
     */
    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority=" + authority +
                ", users=" + users +
                '}';
    }
}
