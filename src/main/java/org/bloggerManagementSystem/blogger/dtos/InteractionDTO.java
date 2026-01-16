package org.bloggerManagementSystem.blogger.dtos;

import org.bloggerManagementSystem.blogger.entity.enums.InteractionType;

import java.time.LocalDateTime;

public class InteractionDTO {

    private Long blogId;

    private Long userId;

    private Long commentId; // Nullable, for interactions on comments

    private InteractionType type; // e.g., "LIKE", "SHARE"

    private LocalDateTime reactionTimestamp;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public InteractionType getType() {
        return type;
    }

    public void setType(InteractionType type) {
        this.type = type;
    }

    public LocalDateTime getReactionTimestamp() {
        return reactionTimestamp;
    }

    public void setReactionTimestamp(LocalDateTime reactionTimestamp) {
        this.reactionTimestamp = reactionTimestamp;
    }
}
