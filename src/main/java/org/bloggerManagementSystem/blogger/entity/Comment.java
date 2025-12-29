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
    @JoinColumn(name = "blogID", referencedColumnName = "blogID", nullable = false)
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    private User user;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
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


}
