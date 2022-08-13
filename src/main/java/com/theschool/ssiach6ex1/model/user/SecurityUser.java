package com.theschool.ssiach6ex1.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The {@code SecurityUser} is a wrapper class for the {@code User} class.
 * It wraps a {@code User} around security related attributes.
 *
 * @see com.theschool.ssiach6ex1.model.user.User
 * @author Thomas Munguya
 */
public class SecurityUser implements UserDetails {

    /**
     * Defines the wrapped user.
     */
    private final User user;

    /**
     * Constructs a {@code SecurityUser} with the provider user.
     * @param user the user.
     */
    public SecurityUser(User user) {
        this.user = user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities()
                    .stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.toString()))
                    .collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Determines if this authority is equal to {@code otherSecurityUser}.
     * @param otherSecurityUser the product to compare to this product.
     * @return {@code true} if this product is equal to {@code otherSecurityUser}.
     */
    @Override
    public boolean equals(Object otherSecurityUser) {
        if (this == otherSecurityUser) return true;
        if (!(otherSecurityUser instanceof SecurityUser securityUser)) return false;
        return user.equals(securityUser.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
