package org.bloggerManagementSystem.blogger.entity;

import jakarta.persistence.*;
import org.bloggerManagementSystem.blogger.entity.enums.InteractionType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "interactions")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interactionID")
    private Long interactionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blogID",referencedColumnName = "blogID")
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID",referencedColumnName = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentID", referencedColumnName = "commentID")
    private Comment comment; // Nullable, for interactions on comments

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private InteractionType type; // e.g., "LIKE", "SHARE"

    @CreationTimestamp
    @Column(name = "reactionTimestamp")
    private LocalDateTime reactionTimestamp;


    public Interaction() {
    }

    public Interaction(Long interactionID, Blog blog, User user, Comment comment, InteractionType type, LocalDateTime reactionTimestamp) {
        this.interactionID = interactionID;
        this.blog = blog;
        this.user = user;
        this.comment = comment;
        this.type = type;
        this.reactionTimestamp = reactionTimestamp;
    }

    public Long getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(Long interactionID) {
        this.interactionID = interactionID;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
