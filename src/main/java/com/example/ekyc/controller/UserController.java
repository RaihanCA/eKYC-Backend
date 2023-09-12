package com.example.ekyc.controller;

import com.example.ekyc.DTO.UserDTO;
import com.example.ekyc.entity.UserEntity;
import com.example.ekyc.repository.UserRepository;
import com.example.ekyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
public class UserController{
//    UserService userService = new UserService();
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userdto){
        String something = userService.addUser(userdto);
        if(something != null){
            return ResponseEntity.ok(something);
        }
        else return ResponseEntity.notFound().build();



    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId){
        UserDTO userDTO = userService.getUserById(userId);
        if(userDTO != null){
            return ResponseEntity.ok(userDTO);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody UserDTO userdto) {
        boolean updated = userService.updateUser(userId, userdto);
        if (updated) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
