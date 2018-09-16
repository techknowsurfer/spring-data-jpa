package com.techknowsurfer.springdatajpa.controller;


import com.techknowsurfer.springdatajpa.domain.Category;
import com.techknowsurfer.springdatajpa.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "/categories",method =  RequestMethod.GET)
    public List<Category> getAllCategoriesSorted(){
        return categoryService.findByAllCategoryAndSort();
    }

    @RequestMapping(value = "/categories",method =  RequestMethod.GET,params = "categoryName")
    public List<Category> getAllCategoriesLike(@RequestParam("categoryName") String categoryName){
        return categoryService.findByCategoryNameAndSort(categoryName);
    }

}
