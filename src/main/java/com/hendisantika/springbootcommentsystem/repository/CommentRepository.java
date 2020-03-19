package com.hendisantika.springbootcommentsystem.repository;

import com.hendisantika.springbootcommentsystem.model.Comment;
import com.hendisantika.springbootcommentsystem.model.CustomCommentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-comment-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/03/20
 * Time: 06.33
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /*
    Select child nodes from a parent node
     */
    @Query("SELECT NEW CustomCommentResult(c.id, c.name, c.content, c.parentId)" +
            "FROM Comment as c WHERE parentId = :parentId")
    List<CustomCommentResult> findByParent(@Param("parentId") Long parentId);
}