package org.bloggerManagementSystem.blogger.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private Long commentID;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "blogID", referencedColumnName = "blogID")
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user;

    @Column(name = "content")
    private String content;

    @CreationTimestamp
    @Column(name = "createdAt",updatable = false)
    private LocalDateTime createdAt;

    public Comment() {
    }

    public Comment(Long commentID, Blog blog, User user, String content, LocalDateTime createdAt) {
        this.commentID = commentID;
        this.blog = blog;
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
