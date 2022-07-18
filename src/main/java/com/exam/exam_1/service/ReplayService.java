package com.exam.exam_1.service;

import com.exam.exam_1.dao.ReplayRepository;
import com.exam.exam_1.domain.Article;
import com.exam.exam_1.domain.Replay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplayService {
    private final ReplayRepository replayRepository;

    public void create(Article article, String content) {
        Replay replay = new Replay();
        replay.setContent(content);
        replay.setCreateDate(LocalDateTime.now());
        replay.setArticle(article);
        this.replayRepository.save(replay);
    }
}
