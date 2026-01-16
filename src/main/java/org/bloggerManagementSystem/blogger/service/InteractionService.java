package org.bloggerManagementSystem.blogger.service;

import org.bloggerManagementSystem.blogger.dtos.InteractionDTO;
import org.bloggerManagementSystem.blogger.dtos.ResponseDTO;
import org.bloggerManagementSystem.blogger.entity.Blog;
import org.bloggerManagementSystem.blogger.entity.Comment;
import org.bloggerManagementSystem.blogger.entity.Interaction;
import org.bloggerManagementSystem.blogger.entity.User;
import org.bloggerManagementSystem.blogger.repository.BlogRepository;
import org.bloggerManagementSystem.blogger.repository.CommentRepository;
import org.bloggerManagementSystem.blogger.repository.InteractionRepository;
import org.bloggerManagementSystem.blogger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InteractionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private InteractionRepository interactionRepository;

    public ResponseDTO createInteration(InteractionDTO interactionDTO) {
        Optional<User> optionalUser = userRepository.findById(interactionDTO.getUserId());
        Optional<Blog> optionalBlog = blogRepository.findById(interactionDTO.getBlogId());
        Optional<Comment> optionalComment = commentRepository.findById(interactionDTO.getCommentId());

        if(optionalBlog.isEmpty() || optionalUser.isEmpty() || optionalComment.isEmpty()){
            return new ResponseDTO("Some data is incorrect", interactionDTO);
        }

        Interaction interaction = new Interaction();
        interaction.setBlog(optionalBlog.get());
        interaction.setComment(optionalComment.get());
        interaction.setUser(optionalUser.get());
        interaction.setReactionTimestamp(LocalDateTime.now());
        interaction.setType(interactionDTO.getType());

        Interaction resultInteraction = interactionRepository.save(interaction);

        return new ResponseDTO("Interaction is Created", resultInteraction);
    }
}
