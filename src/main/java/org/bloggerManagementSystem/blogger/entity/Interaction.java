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
    @JoinColumn(name = "blogID",nullable = false, referencedColumnName = "blogID")
    private Blog blog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID",nullable = false, referencedColumnName = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentID", referencedColumnName = "commentID")
    private Comment comment; // Nullable, for interactions on comments

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
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

}
