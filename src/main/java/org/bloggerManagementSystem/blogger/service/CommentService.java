package org.bloggerManagementSystem.blogger.service;


import org.bloggerManagementSystem.blogger.dtos.CommentDTO;
import org.bloggerManagementSystem.blogger.dtos.ResponseDTO;
import org.bloggerManagementSystem.blogger.entity.Blog;
import org.bloggerManagementSystem.blogger.entity.Comment;
import org.bloggerManagementSystem.blogger.entity.User;
import org.bloggerManagementSystem.blogger.repository.BlogRepository;
import org.bloggerManagementSystem.blogger.repository.CommentRepository;
import org.bloggerManagementSystem.blogger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    public ResponseDTO createComment(CommentDTO commentDto) {
        Optional<User> optionalUser = userRepository.findById(commentDto.getUserID());
        Optional<Blog> optionalBlog = blogRepository.findById((commentDto.getBlogID()));

        if (optionalBlog.isEmpty() || optionalUser.isEmpty()){
            return new ResponseDTO("Erro come at time  of getting blog or user details", "");
        }

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setBlog(optionalBlog.get());
        comment.setUser(optionalUser.get());
        comment.setCreatedAt(LocalDateTime.now());
        Comment result  = commentRepository.save(comment);
        return new ResponseDTO("Succesfully created", result);
    }

    public ResponseDTO updateComment(Comment comment) {
        Optional<Comment> optionalComment = commentRepository.findById(comment.getCommentID());
        if(optionalComment.isEmpty()){
            return new ResponseDTO("Comment Id is not correct", comment);
        }

        Comment temp_comment = optionalComment.get();
        if(comment.getContent() != null){
            temp_comment.setContent(comment.getContent());
            Comment result = commentRepository.save(temp_comment);
            return new ResponseDTO("Successfully Updated", result);
        }
        return new ResponseDTO("Content or Message not there", comment);
    }

    public ResponseDTO deleteComment(Long blogId, Long commentId, Long userId) {
        Optional<Comment> optionalComment = commentRepository.findByBlogIdAndCommentIdAndUserId(blogId,
                                                                                            commentId, userId);
        if (optionalComment.isEmpty()){
            String dataFailed = "BlogId : " + blogId + "  CommentID : "+ commentId + " UserId : " + userId;
            return new ResponseDTO("Not able to delete", dataFailed);
        }
        commentRepository.delete(optionalComment.get());
        return new ResponseDTO("Comment has been deleted", optionalComment.get());
    }

    public ResponseDTO getCommentByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()){
            return new ResponseDTO("User is not available", userId);
        }

        Optional<List<Comment>> optionalComment = commentRepository.findByUserId(userId);
        return optionalComment.map(
                comments -> new ResponseDTO("Comment Found", comments)).
                orElseGet(() -> new ResponseDTO("No Comment Found ", optionalComment));
    }

    public ResponseDTO getCommentByBlogId(Long blogId) {
        Optional<List<Comment>> optionalComment = commentRepository.findByBlogId(blogId);

        return optionalComment.map(
                comments -> new ResponseDTO("Comment Found Using BlogId", comments)).
                orElseGet(() -> new ResponseDTO("No Comment Found Using BlogId", optionalComment));
    }

    public ResponseDTO getAllComment() {
        Optional<List<Comment>> optionalComments = Optional.of(commentRepository.findAll());

        return optionalComments.map(
                comments -> new ResponseDTO("All Comment Found", comments)).
                orElseGet(() -> new ResponseDTO("No Comment Found", optionalComments));
    }
}