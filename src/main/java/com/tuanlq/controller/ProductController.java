package com.tuanlq.controller;

import com.tuanlq.model.Category;
import com.tuanlq.model.Product;
import com.tuanlq.service.CategoryService;
import com.tuanlq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    Iterable<Category> getCategories(){
        return categoryService.findAllSuppliersByMe();
    }

    @GetMapping("/product-list")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Product> products;
        if(s.isPresent()){
            products = productService.findAllByNameContaining(s.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/product-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/product-create")
    public ModelAndView saveCustomer(@ModelAttribute("product") Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/product-edit/{id}")
    public ModelAndView getFormEditMaterial(@PathVariable int id){
        Product product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories",getCategories());
        return modelAndView;
    }
    @PostMapping("/product-edit")
    public ModelAndView editMaterial(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product-list");
        return modelAndView;
    }
    @GetMapping("/product-delete/{id}")
    public ModelAndView deleteMaterial(@PathVariable int id){
        productService.deleteMaterialById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/product-list");
        return modelAndView;
    }

}
