package org.bloggerManagementSystem.blogger.controller;

import org.bloggerManagementSystem.blogger.dtos.CommentDTO;
import org.bloggerManagementSystem.blogger.dtos.ResponseDTO;
import org.bloggerManagementSystem.blogger.entity.Comment;
import org.bloggerManagementSystem.blogger.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // create comment (single comment) --> POST /comment  (RequestBody)  DONE
    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createComment(@RequestBody CommentDTO commentDto) {
        ResponseDTO responseDTO = commentService.createComment(commentDto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // update comment --> PUT /comment  (RequestBody)
    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateComment(@RequestBody Comment comment){
        ResponseDTO responseDTO = commentService.updateComment(comment);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    // delete comment by id --> DELETE /comment:id=ashu
    @DeleteMapping("/{blogId}/{commentId}/{userId}")
    public ResponseEntity<ResponseDTO> deleteComment(@PathVariable Long blogId,@PathVariable Long commentId,
                                                     @PathVariable Long userId) {
        ResponseDTO responseDTO = commentService.deleteComment(blogId,commentId,userId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // get comment by id --> GET /comment:id=ashu
    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDTO> getCommnetByUserId(@PathVariable Long userId){
        ResponseDTO responseDTO = commentService.getCommentByUserId(userId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // get all comments by blog id --> GET /commentsbypostid:blogid=1234
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getCommentByBlogId(@RequestParam Long blogId) {
        ResponseDTO responseDTO = commentService.getCommentByBlogId(blogId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // get all comments --> GET /comments
    @GetMapping("/")
    public  ResponseEntity<ResponseDTO> getAllComment(){
        ResponseDTO responseDTO = commentService.getAllComment();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}


// get all comments by user id --> GET /commentsbyuserid:userid=ashu

