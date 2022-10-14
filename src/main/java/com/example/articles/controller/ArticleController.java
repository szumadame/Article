package com.example.articles.controller;

import com.example.articles.model.Article;
import com.example.articles.service.ArticleService;
import com.example.articles.service.NytApiClient;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ArticleController {

    @Autowired
    private final ArticleService articleService;
    NytApiClient nytApiClient;

    @GetMapping("/articles/byTitle")
    ResponseEntity<List<Article>> getAllArticles() throws JSONException, ParseException {
        articleService.saveArticles();
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping(value = "/articles/apiResponse", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getArticlesTable() throws JSONException {
        return ResponseEntity.ok(nytApiClient.getArticlesTable().toString());
    }

    @GetMapping("/articles/save")
    HttpStatus saveArticles() throws JSONException, ParseException {
        articleService.saveArticles();
        return HttpStatus.OK;
    }

    @GetMapping("/articles/byId/{articleId}")
    ResponseEntity<Optional<Article>> getArticleById(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.getArticleById(articleId));
    }

    @GetMapping("/articles/titles/table")
    ResponseEntity<List<String>> getArticlesTitlesTable() {
        return ResponseEntity.ok(articleService.getArticleTitlesTable());
    }
}
