package com.tuanlq.service;

import com.tuanlq.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Product getProductById(int id);
    void saveProduct(Product product);
    void deleteMaterialById(int id);
}
