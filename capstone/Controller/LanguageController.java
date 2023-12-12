package com.example.capstone.Controller;

import com.example.capstone.Model.Language;
import com.example.capstone.Service.LanguageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;
    Logger logger= LoggerFactory.getLogger(Language.class);
    @GetMapping("/getLanguage")
    public ResponseEntity getLanguage(){
        logger.info("you are in get Language Controller");

        return ResponseEntity.status(HttpStatus.OK).body(languageService.getLanguage());
    }
    @PostMapping("/addLanguage")
    public ResponseEntity addLanguage(@RequestBody@Valid Language language){
        logger.info("you are in add Language Controller");

        languageService.addLanguage(language);
        return ResponseEntity.status(HttpStatus.OK).body("Language add");
    }
    @PutMapping("/updateLanguage/{id}")
    public ResponseEntity updateLanguage(@PathVariable Integer id,@RequestBody@Valid Language language){
        logger.info("you are in update Language  Controller");

        languageService.updateLanguage(id, language);
        return ResponseEntity.status(HttpStatus.OK).body("Language updated");
    }
    @DeleteMapping("/deleteLanguage/{id}")
    public ResponseEntity deleteLanguage(@PathVariable Integer id){
        logger.info("you are in delete Language Controller");
        languageService.deleteLanguage(id);
        return ResponseEntity.status(HttpStatus.OK).body("Language deleted");
    }
    @GetMapping("/getByName/{language_name}")
    public ResponseEntity languageName(@PathVariable String language_name){
        logger.info("you are in get Language by name Controller");

        return ResponseEntity.status(HttpStatus.OK).body(languageService.languageName(language_name));
    }
}
