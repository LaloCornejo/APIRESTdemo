package com.L.LO.APIdemo.articles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaArticleService implements ArticleService {
  @Autowired
  private ArticleRepository articleRepository;

  @Override
  public List<Article> findAll() {
    List<Article> list = new ArrayList<>();
    articleRepository.findAll().forEach(list::add);
    return list;
  }

  @Override
  public Article create(Article article) {
    return articleRepository.save(article);
  }

  @Override
  public Article findOne(Long id) {
    return articleRepository.findById(id).orElse(null);
  }

  @Override
  public Article partialUpdate(Long id, Article article) {
    Article existingArticle = this.findOne(id);
    if (existingArticle == null) {
      return null;
    }
    if (article.getDescription() != null) {
      existingArticle.setDescription(article.getDescription());
    }
    if (article.getPrice() != null) {
      existingArticle.setPrice(article.getPrice());
    }
    return articleRepository.save(existingArticle);
  }

  @Override
  public Article update(Long id, Article article) {
    Article existingArticle = this.findOne(id);
    if (existingArticle == null) {
      return null;
    }
    existingArticle.setDescription(article.getDescription());
    existingArticle.setPrice(article.getPrice());
    return articleRepository.save(existingArticle);
  }

  @Override
  public boolean delete(Long id) {
    Article existingArticle = this.findOne(id);
    if (existingArticle == null) {
      return false;
    }
    articleRepository.delete(existingArticle);
    return true;
  }
}
