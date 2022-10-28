package com.footprints.businessservice.domain.board.comment.service;

import com.footprints.businessservice.domain.board.article.dto.ArticleDto;
import com.footprints.businessservice.domain.board.article.entity.Article;
import com.footprints.businessservice.domain.board.comment.dto.CommentRequest;
import com.footprints.businessservice.domain.board.comment.dto.CommentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    List<CommentDto> getCommentList(Article articleId, Pageable pageable);

    void saveComment(CommentRequest request);
}
