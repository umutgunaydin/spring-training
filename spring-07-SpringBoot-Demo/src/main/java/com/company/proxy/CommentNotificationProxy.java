package com.company.proxy;

import com.company.model.Comment;
import org.springframework.stereotype.Component;


public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
