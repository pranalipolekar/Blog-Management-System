package org.bloggerManagementSystem.blogger.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bloggerManagementSystem.blogger.entity.enums.userRole;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private BigInteger userID;


    private String userName;

    @Setter(AccessLevel.PRIVATE)
    private String email;

    @Setter(AccessLevel.NONE)
    private String password;

    @Enumerated(EnumType.STRING)
    private userRole role;
    private Timestamp createdAt;
    private Timestamp updatedAt;







}
