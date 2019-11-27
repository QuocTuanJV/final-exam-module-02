package com.tuanlq.controller;

import com.tuanlq.model.Category;
import com.tuanlq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category-create")
    public ModelAndView getFormCreateSupplier(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    @PostMapping("/category-create")
    public ModelAndView createSupplier(@ModelAttribute("category") Category category){
        categoryService.createNewCategory(category);
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }
}
