package com.theschool.ssiach6ex1.repository.product;

import com.theschool.ssiach6ex1.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The {@code ProductRepository} interface represents a type is responsible for handling
 * persistence logic pertaining to products.
 *
 * @author Thomas Munguya
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
