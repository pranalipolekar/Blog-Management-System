package org.bloggerManagementSystem.blogger.controller;

import org.bloggerManagementSystem.blogger.dtos.InteractionDTO;
import org.bloggerManagementSystem.blogger.dtos.ResponseDTO;
import org.bloggerManagementSystem.blogger.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntractionController {

    @Autowired
    private InteractionService interactionService;

    // create ineration post /interaction (RequestBody)
    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createInteration(@RequestBody InteractionDTO interactionDTO){
        ResponseDTO responseDTO = interactionService.createInteration(interactionDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}

// get interaction by id  get /interaction:id=1
// get interactions by blog id  get /interactions:blogid=1
// get interactions by user id  get /interactions:userid=1
// get interactions by comment id  get /interactions:commentid=1
// get interactions by type  get /interactions:type=LIKE
// delete interaction by id  delete /interaction:id=1
// get all interactions  get /interactions
// update interaction put /interaction (RequestBody)