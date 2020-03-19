package com.hendisantika.springbootcommentsystem.controller;

import com.hendisantika.springbootcommentsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
