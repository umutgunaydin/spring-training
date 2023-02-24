package com.company.service;

import com.company.config.AppConfigData;
import com.company.config.DBConfigData;
import com.company.model.Comment;
import com.company.proxy.CommentNotificationProxy;
import com.company.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public void printConfigData() {
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());

    }

    public void printDbConfigData(){
        System.out.println(dbConfigData.getUserName());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }
}
