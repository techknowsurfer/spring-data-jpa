package com.techknowsurfer.springdatajpa.service;

import com.techknowsurfer.springdatajpa.domain.Category;
import com.techknowsurfer.springdatajpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findByAllCategoryAndSort(){
        return categoryRepository.findAll(Sort.by("categoryName"));
    }

    public List<Category> findByCategoryNameAndSort(String categoryName){
        return categoryRepository.findByCategoryNameAndSort(categoryName,Sort.by("categoryName"));
    }

    public List<String> findByCategoryNameContainsAndSortByLength(String categoryName){
        return categoryRepository.findByCategoryNameContainsAndSortByLength(categoryName, JpaSort.unsafe("LENGTH(categoryName)"));
    }
}
