package com.techknowsurfer.springdatajpa.repository;


import com.techknowsurfer.springdatajpa.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    Article findByArticleTitle(String articleTitle);

    Article findByAuthorFirstNameAndAuthorLastName(String authorFirstName,String authorLastName);

    List<Article> findByArticleTitleContaining(String articleTitle);


    @Query(value = "SELECT a FROM Article a WHERE a.articleTitle = ?1 AND a.authorFirstName = ?2")
    Article findByArticleTitleAndAuthorFirstName(String articleTitle, String authorFirstName);

    @Query(value = "SELECT a FROM Article a WHERE a.articleTitle = :authorFirstName OR a.authorFirstName = :authorLastName")
    Article findByAuthorFirstNameOrAuthorLastName(@Param("authorFirstName") String authorFirstName,
                                                  @Param("authorLastName") String authorLastName);

    @Query(value = "SELECT * FROM ARTICLE a WHERE a.active = true", nativeQuery = true)
    List<Article> findAllActiveUsers();
}
