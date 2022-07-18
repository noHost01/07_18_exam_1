package com.exam.exam_1.controller;

import com.exam.exam_1.domain.Article;
import com.exam.exam_1.service.ArticleService;
import com.exam.exam_1.service.ReplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/replay")
@RequiredArgsConstructor
@Controller
public class ReplayController {

    private final ArticleService articleService;

    private final ReplayService replayService;

    @RequestMapping("/create/{id}")
    @ResponseBody
    public String createReplay(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Article article = this.articleService.getArticle(id);
        this.replayService.create(article, content);
        return String.format("redirect/article/detail/%s", id);
    }
}
