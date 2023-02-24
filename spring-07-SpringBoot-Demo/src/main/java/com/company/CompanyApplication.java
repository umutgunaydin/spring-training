package com.company;

import com.company.model.Comment;
import com.company.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {

        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext container = SpringApplication.run(CompanyApplication.class, args);

        CommentService commentService=container.getBean(CommentService.class);
        commentService.publishComment(comment);

        commentService.printConfigData();

    }

}
