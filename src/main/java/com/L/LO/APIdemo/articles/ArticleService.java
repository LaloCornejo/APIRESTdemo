package com.L.LO.APIdemo.articles;

import java.util.List;

public interface ArticleService {
  public List<Article> findAll();

  public Article create(Article article);

  public Article findOne(Long id);

  public Article partialUpdate(Long id, Article article);

  public Article update(Long id, Article article);

  public boolean delete(Long id);
}
