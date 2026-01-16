package org.bloggerManagementSystem.blogger.repository;

import org.bloggerManagementSystem.blogger.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("""
    SELECT c FROM Comment c WHERE c.blogID = :blogId AND c.commentID = :commentId AND c.userID = :userId""")
    Optional<Comment> findByBlogIdAndCommentIdAndUserId(
            @Param("blogId") Long blogId,
            @Param("commentId") Long commentId,
            @Param("userId") Long userId
    );

    @Query("""
    SELECT c FROM Comment c WHERE c.userID = :userId""")
    Optional<List<Comment>> findByUserId(Long userId);

    @Query("SELECT c FROM Comment c WHERE c.blogID = :blogId")
    Optional<List<Comment>> findByBlogId(Long blogId);
}
