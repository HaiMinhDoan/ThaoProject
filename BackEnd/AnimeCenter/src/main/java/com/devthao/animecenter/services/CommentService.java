package com.devthao.animecenter.services;

import com.devthao.animecenter.models.entities.Comment;
import com.devthao.animecenter.models.request.CommentRequest;

import java.util.List;

public interface CommentService {
    void saveComment(CommentRequest comment);
    List<Comment> getCommentsByMovieId(Long movieId);
}
