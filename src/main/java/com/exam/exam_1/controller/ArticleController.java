package com.exam.exam_1.controller;

import com.exam.exam_1.domain.Article;
import com.exam.exam_1.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/article")
@Controller
@AllArgsConstructor
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public String showList(Model model) {
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);
        return "Article_List";
    }

    @RequestMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "Article_detail";
    }
}
