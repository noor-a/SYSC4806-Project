package controllers;



import models.SubmitterEntity;
import models.Article;
import repositoires.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    @GetMapping("/api/articles")



    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }



    public Article createArticle(@Valid @RequestBody Article article, Principal principal) {
        //**To add here article to user submitted articles
        return articleRepository.save(article);
    }



}