package com.tuanlq.repository;

import com.tuanlq.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}

