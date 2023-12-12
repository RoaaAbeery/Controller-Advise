package com.example.capstone.Controller;

import com.example.capstone.Model.Tutorial;
import com.example.capstone.Service.TutorialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Tutorial")
@RequiredArgsConstructor
public class TutorialController {
    private  final TutorialService tutorialService;
        Logger logger= LoggerFactory.getLogger(Tutorial.class);
    @GetMapping("/getTutorial")
    public ResponseEntity getTutorial (){
        logger.info("you are in get Tutorial Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getTutorial());
    }
    @PostMapping("/addTutorial")
    public ResponseEntity addTutorial(@RequestBody@Valid Tutorial tutorial) {
        logger.info("you are in add Tutorial Controller");

        tutorialService.addTutorial(tutorial);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial add");
    }
    @PutMapping("/updateTutorial/{id}")
    public ResponseEntity updateTutorial(@PathVariable Integer id, @RequestBody@Valid Tutorial tutorial){
        logger.info("you are in update Tutorial Controller");

        tutorialService.updateTutorial(id, tutorial);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial updated");
    }
    @DeleteMapping("/deleteTutorial/{id}")
    public ResponseEntity deleteTutorial(@PathVariable Integer id){
        logger.info("you are in delete Tutorial Controller");

        tutorialService.deleteTutorial(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tutorial deleted");
    }
    @GetMapping("/getUserID/{user_id}")
    public ResponseEntity getByUserId(@PathVariable Integer user_id){
        logger.info("you are in get Tutorial by user id Controller");

        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByUser_id(user_id));
    }
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        logger.info("you are in get Tutorial by title Controller");

        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByTitle(title));
    }

    @GetMapping("/getDifficulty_level/{difficulty_level}")
    public ResponseEntity getDifficulty_level(@PathVariable String difficulty_level){
        logger.info("you are in get Tutorial by difficulty level Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByDifficulty_level(difficulty_level));
    }
    @GetMapping("/getFavorites/{user_id}")
    public ResponseEntity getFavorites(@PathVariable Integer user_id){
        logger.info("you are in get Favorites Tutorial for user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getFavorites(user_id));
    }
    @PutMapping("/unFavorites/{user_id}/{id}")
    public ResponseEntity unFavorites(@PathVariable Integer user_id,@PathVariable Integer id){
        logger.info("you are in delete Tutorial from Favorites Tutorial for user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.unFavorites(user_id, id));
    }
    @PutMapping("/Favorites/{user_id}/{id}")
    public ResponseEntity Favorites(@PathVariable Integer user_id,@PathVariable Integer id){
        logger.info("you are in add Tutorial to Favorites Tutorial for user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.addFavorites(user_id, id));
    }
    @GetMapping("/countUnFavorites/{user_id}")
    public ResponseEntity countUnfavorites(@PathVariable Integer user_id){
        logger.info("you are in count Favorites Tutorial for user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.countUnFavorites(user_id));
    }
    @GetMapping("/countFavorites/{user_id}")
    public ResponseEntity countfavorites(@PathVariable Integer user_id){
        logger.info("you are in count unFavorites Tutorial for user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.countFavorites(user_id));
    }
    @GetMapping("/getByAuthor{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        logger.info("you are in get Tutorial by author Controller");
        return ResponseEntity.status(HttpStatus.OK).body(tutorialService.getByAuthor(author));
    }
}
