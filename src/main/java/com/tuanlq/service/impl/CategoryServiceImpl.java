package com.tuanlq.service.impl;

import com.tuanlq.model.Category;
import com.tuanlq.repository.CategoryRepository;
import com.tuanlq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void createNewCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> findAllSuppliersByMe() {
        return categoryRepository.findAll();
    }
}
