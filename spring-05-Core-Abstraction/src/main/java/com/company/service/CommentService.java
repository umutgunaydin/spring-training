package com.company.service;

import com.company.model.Comment;
import com.company.proxy.CommentNotificationProxy;
import com.company.repository.CommentRepository;
import com.company.repository.DBCommentRepository;

public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        //save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);

    }
}
