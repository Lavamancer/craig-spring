package com.lavamancer.craig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired UserService userService;


    @GetMapping("/api/users/create")
    public ResponseEntity<User> postUser() {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create());
    }

    @GetMapping("/api/users")
    public ResponseEntity<User> getUser(@RequestParam Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }


    @GetMapping("/")
    public ResponseEntity<String> getIndex() {
        return ResponseEntity.status(HttpStatus.OK).body("Spring");
    }

    @GetMapping("/public/test")
    public ResponseEntity<String> getTest() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello Craig");
    }
}
