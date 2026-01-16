package org.bloggerManagementSystem.blogger.repository;

import org.bloggerManagementSystem.blogger.entity.Interaction;
import org.bloggerManagementSystem.blogger.entity.enums.InteractionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    @Query("SELECT * FROM interactions WHERE blogID = :blogId ")
    Optional<List<Interaction>> findByBlogId(Long blogId);

    @Query("SELECT * FROM interactions WHERE userID = :userId ")
    Optional<List<Interaction>> findByUserId(Long userId);

    @Query("SELECT * FROM interactions WHERE commentID = :commentId ")
    Optional<List<Interaction>> findByCommentId(Long commentId);

    @Query("SELECT * FROM interactions WHERE type = :type ")
    Optional<List<Interaction>> findByType(InteractionType type);
}
