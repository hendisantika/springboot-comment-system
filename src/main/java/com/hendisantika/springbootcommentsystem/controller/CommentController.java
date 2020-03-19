package com.hendisantika.springbootcommentsystem.controller;

import com.hendisantika.springbootcommentsystem.model.Comment;
import com.hendisantika.springbootcommentsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-comment-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 06.34
 */
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    /*
   Select all comments
    */
    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getAllComments(HttpServletResponse response) {
        /*
        Access cors
         */
        response.addHeader("Access-Control-Allow-Origin", "*");
        return commentRepository.findAll();
    }

    /*
   Post a comment
    */
    @PostMapping("/comments")
    @ResponseBody
    public Comment createComment(Comment comment, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return commentRepository.save(comment);
    }
}
