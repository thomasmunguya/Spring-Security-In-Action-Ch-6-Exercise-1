package com.theschool.ssiach6ex1.model.product;

import com.theschool.ssiach6ex1.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

/**
 * Represents a product.
 *
 * @author Thomas Munguya
 */
@Entity
public class Product {

    /**
     * Defines the identifier of the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Defines the name of the product.
     */
    @NotNull
    @Size(min = 1)
    private String name;

    /**
     * Defines the price of the product.
     */
    @NotNull
    @Min(0)
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<User> users;

    /**
     * Constructs a product.
     */
    public Product() {
    }

    /**
     * Constructs a product with the provided arguments.
     * @param name the name of the product.
     * @param price the price of the product.
     */
    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    /**
     * Returns the identifier of the product.
     * @return the identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the name of the product.
     * @return the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name the name of the product.
     * @throws IllegalArgumentException if {@code name} is null or empty.
     */
    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name provided");
        }
        this.name = name;
    }

    /**
     * Returns the price of the product.
     * @return the price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the price.
     * @throws IllegalArgumentException if {@code price} is less than zero.
     */
    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Invalid price provided");
        }
        this.price = price;
    }

    public List<User> getUsers() {
        return List.copyOf(users);
    }

    /**
     * Sets the users owning this product.
     * @param users the users.
     * @throws IllegalArgumentException if {@code users} is {@code null} or empty.
     */
    public void setUsers(List<User> users) {
        if(users == null || users.isEmpty()) {
            throw new IllegalArgumentException("null or empty list of users provided");
        }
        this.users = users;
    }

    /**
     * Determines if this product is equal to {@code otherProduct}.
     * @param otherProduct the product to compare to this product.
     * @return {@code true} if this product is equal to {@code otherProduct}.
     */
    @Override
    public boolean equals(Object otherProduct) {
        if (this == otherProduct) return true;
        if (!(otherProduct instanceof Product product)) return false;
        return getId().equals(product.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /**
     * Returns a string representation of the product.
     * @return the string representation of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", users=" + users +
                '}';
    }
}
