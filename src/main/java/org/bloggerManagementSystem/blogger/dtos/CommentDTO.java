package org.bloggerManagementSystem.blogger.dtos;

import java.time.LocalDateTime;

public class CommentDTO {

    private Long blogID;
    private Long userID;
    private String content;
    private LocalDateTime createdAt;

    public CommentDTO() {
    }

    public CommentDTO(Long blogID, Long userID, String content, LocalDateTime createdAt) {
        this.blogID = blogID;
        this.userID = userID;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getBlogID() {
        return blogID;
    }

    public void setBlogID(Long blogID) {
        this.blogID = blogID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}