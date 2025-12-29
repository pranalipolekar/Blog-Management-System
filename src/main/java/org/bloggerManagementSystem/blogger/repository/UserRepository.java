package org.bloggerManagementSystem.blogger.repository;

import org.bloggerManagementSystem.blogger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
