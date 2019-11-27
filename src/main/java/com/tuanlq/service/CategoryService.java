package com.tuanlq.service;

import com.tuanlq.model.Category;

public interface CategoryService {
    void createNewCategory(Category category);
    Iterable<Category> findAllSuppliersByMe();
}
