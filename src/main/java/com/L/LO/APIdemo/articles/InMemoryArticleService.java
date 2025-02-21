package com.L.LO.APIdemo.articles;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Service;

//@Service
public class InMemoryArticleService implements ArticleService {
  private static List<Article> items = new ArrayList<>();

  public List<Article> findAll() {
    return items;
  }

  public Article create(Article article) {
    items.add(article);
    return article;
  }

  public Article findOne(Long id) {
    return this.findArticleById(id);
  }

  public Article partialUpdate(Long id, Article article) {
    Article existingArticle = this.findArticleById(id);
    if (existingArticle == null) {
      return null;
    }
    if (article.getDescription() != null) {
      existingArticle.setDescription(article.getDescription());
    }
    if (article.getPrice() != null) {
      existingArticle.setPrice(article.getPrice());
    }
    return existingArticle;
  }

  public Article update(Long id, Article article) {
    Article existingArticle = this.findArticleById(id);
    if (existingArticle == null) {
      return null;
    }
    existingArticle.setDescription(article.getDescription());
    existingArticle.setPrice(article.getPrice());
    return existingArticle;
  }

  public boolean delete(Long id) {
    Article existingArticle = this.findArticleById(id);
    if (existingArticle == null) {
      return false;
    }
    return items.remove(existingArticle);
  }

  private Article findArticleById(Long id) {
    for (Article a : items) {
      if (a.getId().equals(id)) {
        return a;
      }
    }
    return null;
  }
}
