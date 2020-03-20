package com.hendisantika.springbootcommentsystem.controller;

import com.hendisantika.springbootcommentsystem.exception.ResourceNotFoundException;
import com.hendisantika.springbootcommentsystem.model.Comment;
import com.hendisantika.springbootcommentsystem.model.CustomCommentResult;
import com.hendisantika.springbootcommentsystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /*
  Get a comment by id
   */
    @GetMapping("/comments/{id}")
    public Comment getNoteById(@PathVariable(value = "id") Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", commentId));
    }

    /*
    Store html code
     */
    private String html = "";

    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletResponse response) {
        html = "";
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<Comment> comments = commentRepository.findAll();
        for (Comment c : comments) {
            if (c.getParentId() == null) {
                html += "<div class='panel panel-primary'><div class='panel-heading'>By <b>" + c.getName() + "</b" +
                        "></div>" +
                        "<div class='panel-body'>" + c.getContent() + "</div><div class='panel-footer' align='right'>" +
                        "<button type='button' class='btn btn-primary reply' id=" + c.getId() + ">Reply</button></div" +
                        "> </div>";
                parser(c.getId(), 0, true);
            }
        }
        return html;
    }

    /*
    Recursive to construct html code
     */
    public void parser(Long parentId, int level, boolean root) {

        /*
        //Recursive print the tree
        String placeholder = " ";
        for (int i=0; i<level; i++) {
            placeholder += " ";
        }
        System.out.println(placeholder+parentId);
         */

        if (!root) {
            Comment comment = commentRepository.findById(parentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", parentId));

            html += "<div class='panel panel-primary' style='margin-left:" + level * 48 + "px'>" +
                    "<div class='panel-heading'>By <b>" + comment.getName() + "</b></div>" +
                    "<div class='panel-body'>" + comment.getContent() + "</div><div class='panel-footer' " +
                    "align='right'>" +
                    "<button type='button' class='btn btn-primary reply' id=" + comment.getId() + ">Reply</button" +
                    "></div> </div>";

        }

        List<CustomCommentResult> comments = commentRepository.findByParent(parentId);
        if (!comments.isEmpty()) {
            for (CustomCommentResult comment : comments) {
                parser(comment.getId(), level + 1, false);
            }
        }
    }
}
