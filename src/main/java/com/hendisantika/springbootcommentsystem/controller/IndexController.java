package com.hendisantika.springbootcommentsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-comment-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 06.42
 */
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index() {
        return "index";
    }
}
