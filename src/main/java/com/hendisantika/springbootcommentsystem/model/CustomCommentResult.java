package com.hendisantika.springbootcommentsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-comment-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 06.30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomCommentResult {
    /*
   Custom a CustomCommentResult class to select child nodes
   This class filed should to be json
   Sql statement:
       "SELECT NEW  com.hendisantika.springbootcommentsystem.model.CustomCommentResult(c.id, c.name, c.content, c
       .parentId)" +
           "FROM Comment as c WHERE parentId = :parentId"
    */
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("content")
    private String content;

    @JsonProperty("parentId")
    private Long parentId;
}
