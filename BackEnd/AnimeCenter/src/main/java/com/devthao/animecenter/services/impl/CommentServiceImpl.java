package com.devthao.animecenter.services.impl;

import com.devthao.animecenter.exception.FailureActionException;
import com.devthao.animecenter.models.entities.*;
import com.devthao.animecenter.models.request.CommentRequest;
import com.devthao.animecenter.repository.CommentRepository;
import com.devthao.animecenter.repository.TokenRepository;
import com.devthao.animecenter.repository.UserRepository;
import com.devthao.animecenter.services.CommentService;
import com.devthao.animecenter.services.TheaterService;
import com.devthao.animecenter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TheaterService theaterService;
    @Override
    public void saveComment(CommentRequest commentRequest) {
        System.err.println(commentRequest.toString());
            Comment comment = new Comment();
            AuthenEntity authenEntity = commentRequest.getAuthenEntity();
            if (!userService.checkValidAthenEntity(authenEntity)){
                FailureActionException failureActionException = new FailureActionException("Bạn phải đăng nhập để tiếp tục comment!");
                failureActionException.setData(commentRequest);
                throw failureActionException;
            }
            User findingUser = userService.getUserById(authenEntity.getUserId());
            Movie findingMovie = theaterService.getMovieById(commentRequest.getMovieId());
            comment.setText(commentRequest.getContent());
            comment.setUser(findingUser);
            comment.setMovie(findingMovie);
            comment.setCreatedAt(new Date());
            commentRepository.save(comment);

    }

    @Override
    public List<Comment> getCommentsByMovieId(Long movieId) {

        return commentRepository.findCommentsByMovieId(movieId);
    }
}
