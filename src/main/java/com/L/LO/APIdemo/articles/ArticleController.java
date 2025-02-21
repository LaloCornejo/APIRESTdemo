package com.L.LO.APIdemo.articles;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
  @Autowired
  ArticleService articleService;

  @GetMapping("/articles")
  public ResponseEntity<List<Article>> findAll() {
    return new ResponseEntity<>(articleService.findAll(),
        HttpStatus.OK);
  }

  @PostMapping("/articles")
  public ResponseEntity<Article> create(@RequestBody Article article) {
    return new ResponseEntity<>(articleService.create(article),
        HttpStatus.CREATED);
  }

  @GetMapping("/articles/{id}")
  public ResponseEntity<Article> findOne(@PathVariable Long id) {
    Article article = articleService.findOne(id);
    if (article == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(article, HttpStatus.OK);
  }

  @PatchMapping("/articles/{id}")
  public ResponseEntity<Article> partialUpdate(
      @PathVariable Long id, @RequestBody Article article) {
      Article existingArticle = articleService.partialUpdate(id, article);
      if (existingArticle == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(existingArticle, HttpStatus.OK);
      }

  @PutMapping("/articles/{id}")
  public ResponseEntity<Article> update(
      @PathVariable Long id, @RequestBody Article article) {
      Article existingArticle = articleService.update(id, article);
      if (existingArticle == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(existingArticle, HttpStatus.OK);
      }

  @DeleteMapping("/articles/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boolean deleted = articleService.delete(id);
    if (!deleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
