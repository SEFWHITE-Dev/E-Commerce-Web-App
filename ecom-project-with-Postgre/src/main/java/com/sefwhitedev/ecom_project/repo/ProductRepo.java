package com.sefwhitedev.ecom_project.repo;

import com.sefwhitedev.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    // JPQL (JPA Query Language) --similar to SQL, but SQL uses tables and column names, but here we use class and field names
    // convert search input to lower case and compare it to column name contents
//    @Query("SELECT p FROM Product p WHERE " +
//            "LOWER(p.name) LIKE LOWER(CONCAT('%' :keyword, '%')) OR " +
//            "LOWER(p.description) LIKE LOWER(CONCAT('%' :keyword, '%')) OR " +
//            "LOWER(p.brand) LIKE LOWER(CONCAT('%' :keyword, '%')) OR " +
//            "LOWER(p.category) LIKE LOWER(CONCAT('%' :keyword, '%'))")
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
