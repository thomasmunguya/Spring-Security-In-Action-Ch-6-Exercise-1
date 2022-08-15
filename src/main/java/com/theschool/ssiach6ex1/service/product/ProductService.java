package com.theschool.ssiach6ex1.service.product;

import com.theschool.ssiach6ex1.model.product.Product;
import java.util.*;

/**
 * The {@code ProductService} interface represents a type that handles business logic pertaining to products.
 *
 * @author Thomas Munguya.
 */
public interface ProductService {

    /**
     * Retrieves all available products.
     * @return all available products.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves all products belonging to a user by the username.
     * <p>
     * In the event that {@code username} is blank. The list of products returned is always empty.
     * @return all products belonging to a user.
     * @throws IllegalArgumentException if {@code username} is {@code null}.
     */
    List<Product> getProductsByUsername(String username);

    /**
     * Retrieves a product by its product identifier.
     * @param productId the product identifier.
     * @return an {@code Optional} of the product.
     * @throws IllegalArgumentException if {@code productId} is {@code null}.
     */
    Optional<Product> getProductById(Long productId);

    /**
     * Creates a product.
     * @param product the product to create.
     * @throws IllegalArgumentException if {@code product} is {@code null}.
     */
    void createProduct(Product product);

    /**
     * Updates a product.
     * @param product the updated product.
     * @throws IllegalArgumentException if {@code product} is {@code null}.
     */
    void updateProduct(Product product);

    /**
     * Deletes a product by its identifier.
     * <p>
     * In the event that the provided product identifier does not exist, the method fails silently.
     * @param productId the product identifier.
     * @throws IllegalArgumentException if {@code productId} is {@code null}.
     */
    void deleteProductById(Long productId);

    /**
     * Adds a product to a user's list of products.
     * <p>
     * In the case where the user with the {@code username} and/or the product with the {@code productId}
     * cannot be found, the method fails silently.
     * @param username the username of the user.
     * @param productId the product identifier.
     * @throws IllegalArgumentException if {@code username} and/or {@code productId} is {@code null}.
     */
    void addProductToUserProductList(String username, Long productId);

    /**
     * Adds products to a user's list of products.
     * <p>
     * In the following cases, the method will fail silently:
     * <ul>
     *     <li>When the user with {@code username} cannot be found.</li>
     *     <li>When {@code productIds} is empty</li>
     * </ul>
     * In the case that not all products within {@code productIds} can be found, only the products that could be found
     * will be added to the user's product list.
     * @param username the username of the user.
     * @param productIds the product identifiers.
     * @throws IllegalArgumentException if {@code username} and/or {@code productIds} is {@code null}.
     */
    void addProductsToUserProductList(String username, List<Long> productIds);

    /**
     * Removes the product with {@code productId} from the user with {@code username}'s product list.
     * In the case where the user with the {@code username} and/or the product with the {@code productId}
     * cannot be found, the method fails silently.
     * @param username the username of the user.
     * @param productId the product identifier.
     * @throws IllegalArgumentException if {@code username} and/or {@code productId} is {@code null}.
     */
    void removeProductFromUserProductList(String username, Long productId);

    /**
     * Removes products from a user's list of products.
     * <p>
     * In the following cases, the method will fail silently:
     * <ul>
     *     <li>When the user with {@code username} cannot be found.</li>
     *     <li>When {@code productIds} is empty</li>
     * </ul>
     * In the case that not all products within {@code productIds} can be found, only the products that could be found
     * will be removed from user's product list.
     * @param username the username of the user.
     * @param productIds the product identifiers.
     * @throws IllegalArgumentException if {@code username} and/or {@code productIds} is {@code null}.
     */
    void removeProductsFromUserProductList(String username, List<Long> productIds);
}
