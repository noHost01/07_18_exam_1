package com.exam.exam_1.service;

import com.exam.exam_1.dao.ArticleRepository;
import com.exam.exam_1.domain.Article;
import com.exam.exam_1.util.DataNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundExeption("article not fount");
        }
    }
}
