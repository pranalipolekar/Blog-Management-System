package org.bloggerManagementSystem.blogger.controller;

import org.bloggerManagementSystem.blogger.dtos.InteractionDTO;
import org.bloggerManagementSystem.blogger.dtos.ResponseDTO;
import org.bloggerManagementSystem.blogger.entity.enums.InteractionType;
import org.bloggerManagementSystem.blogger.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interaction")
public class IntractionController {

    @Autowired
    private InteractionService interactionService;

    // create ineration post /interaction (RequestBody)
    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createInteration(@RequestBody InteractionDTO interactionDTO){
        ResponseDTO responseDTO = interactionService.createInteration(interactionDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // get interaction by id  get /interaction:id=1
    @GetMapping("/{interactionId}")
    public ResponseEntity<ResponseDTO> getInteractionById(@PathVariable Long interactionId){
        ResponseDTO responseDTO = interactionService.getInteractionById(interactionId);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // get interactions by blog id  get /interactions:blogid=1
    @GetMapping("/blogid/{blogId}")
    public ResponseEntity<ResponseDTO> getInteractionByBlogId(@PathVariable Long blogId){
        ResponseDTO responseDTO = interactionService.getInteractionByBlogId(blogId);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // get interactions by user id  get /interactions:userid=1
    @GetMapping("/userid/{userId}")
    public ResponseEntity<ResponseDTO> getInteractionByUserId(@PathVariable Long userId){
        ResponseDTO responseDTO = interactionService.getInteractionByUserId(userId);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // get interactions by comment id  get /interactions:commentid=1
    @GetMapping("/commentid/{commentId}")
    public ResponseEntity<ResponseDTO> getInteractionByCommentId(@PathVariable Long commentId){
        ResponseDTO responseDTO = interactionService.getInteractionByCommentId(commentId);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // GET /interactions/type/LIKE
    @GetMapping("/type/{type}")
    public ResponseEntity<ResponseDTO> getInteractionByType(@PathVariable InteractionType type) {
        ResponseDTO responseDTO = interactionService.getInteractionByType(type);
        return ResponseEntity.ok(responseDTO);
    }

    // delete interaction by id  delete /interaction:id=1
    @DeleteMapping("/{interactionId}")
    public ResponseEntity<ResponseDTO> deleteInteractionById(@PathVariable Long interactionId) {
        ResponseDTO responseDTO = interactionService.deleteInteractionById(interactionId);
        return ResponseEntity.ok(responseDTO);
    }

    // get all interactions  get /interactions
    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAllInteraction(){
        ResponseDTO responseDTO = interactionService.getAllInteraction();
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
