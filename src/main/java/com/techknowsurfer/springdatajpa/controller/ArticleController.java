package com.techknowsurfer.springdatajpa.controller;


import com.techknowsurfer.springdatajpa.domain.Article;
import com.techknowsurfer.springdatajpa.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @RequestMapping(value = "/welcome",method =  RequestMethod.GET)
    public String welcome(){
        return "Hello World " + new Date();
    }

    @RequestMapping(value = "/articles/{articleId}",method =  RequestMethod.GET)
    public Optional<Article> getArticle(@PathVariable("articleId") String articleId){
        return articleService.getArticle(articleId);
    }

    @RequestMapping(value = "/articles",method =  RequestMethod.GET)
    public List<Article> getAllArticle(){
        return articleService.getAllArticles();
    }

    @RequestMapping(value = "/articles/active",method =  RequestMethod.GET)
    public List<Article> findAllActiveUsers(){
        return articleService.findAllActiveUsers();
    }

    @RequestMapping(value = "/articles",method =  RequestMethod.POST)
    public ResponseEntity createArticle(@RequestBody Article article){
        articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/articles",method =  RequestMethod.PUT)
    public ResponseEntity udpateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/articles",method =  RequestMethod.DELETE)
    public ResponseEntity deleteArticle(@RequestBody Article article){
        articleService.deleteArticle(article);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
