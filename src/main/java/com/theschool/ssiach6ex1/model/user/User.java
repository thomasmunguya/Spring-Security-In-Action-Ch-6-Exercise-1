package com.theschool.ssiach6ex1.model.user;

import com.theschool.ssiach6ex1.model.authority.Authority;
import com.theschool.ssiach6ex1.model.product.Product;
import javax.persistence.*;
import java.util.*;

/**
 * Represents a user.
 *
 * @see com.theschool.ssiach6ex1.model.user.SecurityUser
 * @author Thomas Munguya.
 */
@Entity
public class User {

    /**
     * Defines the username of the user.
     */
    @Id
    private String username;

    /**
     * Defines the password of the user.
     */
    private String password;

    /**
     * Defines the authorities that the user has.
     */
    @ManyToMany
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private Set<Authority> authorities;

    @ManyToMany
    @JoinTable(
            name = "user_products",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "product")
    )
    private List<Product> products;


    /**
     * Returns the username.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     * @param username the username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the user's password.
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password
     * @param password the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's authorities.
     * @return the user's authorities.
     */
    public Set<Authority> getAuthorities() {
        return Set.copyOf(authorities);
    }

    /**
     * Sets the user's authorities.
     * @param authorities the authorities.
     * @throws IllegalArgumentException if {@code authorities} is {@code null} or empty.
     */
    public void setAuthorities(Set<Authority> authorities) {
        if(authorities == null || authorities.isEmpty()) {
            throw new IllegalArgumentException("null or empty list of authorities provided");
        }
        this.authorities = authorities;
    }

    /**
     * Returns the products owned by the user.
     * @return the products own by the user.
     */
    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    /**
     * Sets the products owned by the user.
     * @param products the products.
     * @throws IllegalArgumentException if {@code products} is null.
     */
    public void setProducts(List<Product> products) {
        if(products == null) {
            throw new IllegalArgumentException("null list of products provided.");
        }
        this.products = products;
    }

    /**
     * Determines if this authority is equal to {@code otherUser}.
     * @param otherUser the product to compare to this product.
     * @return {@code true} if this product is equal to {@code otherUser}.
     */
    @Override
    public boolean equals(Object otherUser) {
        if (this == otherUser) return true;
        if (!(otherUser instanceof User user)) return false;
        return getUsername().equals(user.getUsername());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }

    /**
     * Returns a {@code String} representation of this user.
     * @return a {@code String} representation of this user.
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", products=" + products +
                '}';
    }
}
