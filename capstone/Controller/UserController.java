package com.example.capstone.Controller;

import com.example.capstone.Model.User;
import com.example.capstone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUser")
    public ResponseEntity getUser(){
        logger.info("you are in get users Controller");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid User user){
        logger.info("you are in add user Controller");
        userService.addUsers(user);
        return ResponseEntity.status(HttpStatus.OK).body("User add");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody@Valid User user){
        logger.info("you are in update user Controller");

        userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("User Updated");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("you are in delete user Controller");
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }
    @GetMapping("/Check/{email}/{password}")
    public ResponseEntity check(@PathVariable String email ,@PathVariable String password){
        logger.info("you are in check user Controller");
        return ResponseEntity.status(HttpStatus.OK).body(userService.check(email, password));
    }
    @PutMapping ("/ChangeN/{firstName}/{lastName}")
    public ResponseEntity changeName(@PathVariable String firstName ,@PathVariable String lastName,@RequestBody@Valid User user){
        logger.info("you are in change user name Controller");

        userService.changeName(firstName, lastName, user);
        return ResponseEntity.status(HttpStatus.OK).body("name changed");
    }
    @PutMapping ("/Change/{id}/{password}")
    public ResponseEntity changePassword(@PathVariable Integer id ,@PathVariable String password,@RequestBody@Valid User user){
        logger.info("you are in change user password Controller");

        userService.changePass(id, password, user);
        return ResponseEntity.status(HttpStatus.OK).body("Password changed");
    }
    @GetMapping("/getAge/{age}")
    public ResponseEntity getAge(@PathVariable Integer age){
        logger.info("you are in get users based on specifics age Controller");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAgr(age));
    }

}
