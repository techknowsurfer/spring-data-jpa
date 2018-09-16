package com.techknowsurfer.springdatajpa.repository;

import com.techknowsurfer.springdatajpa.domain.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,String> {


    @Query("SELECT C FROM Category C WHERE C.categoryName = :categoryName")
    Category findByCategoryName(@Param("categoryName") String categoryName);


    @Query("SELECT C FROM Category C WHERE C.categoryName LIKE %:categoryName")
    List<Category> findByCategoryNameAndSort(@Param("categoryName") String categoryName, Sort sort);

    @Query("SELECT c.categoryName, LENGTH(c.categoryName) as fn_len from Category c where c.categoryName like %:categoryName%")
    List<String> findByCategoryNameContainsAndSortByLength(@Param("categoryName") String categoryName, Sort sort);

}
