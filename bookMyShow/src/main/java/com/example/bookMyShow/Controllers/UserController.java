/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Controllers;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookMyShow.Models.User;
import com.example.bookMyShow.Services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody AddUserDto user){
        try{
            String result = userService.addUser(user);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //Get oldest User Object by age
    @GetMapping("/getOlderUser")
    public ResponseEntity<UserResponseDto> getOldestUser(){
        try{
            UserResponseDto userResponseDto = userService.getOldestUser();
            userResponseDto.setStatusCode("200");
            userResponseDto.setStatusMessage("SUCCESS");
            return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
        }catch (Exception e){
            UserResponseDto responseDto = new UserResponseDto();
            responseDto.setStatusCode("500");
            responseDto.setStatusMessage("Failure");
            return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findUsersGreaterThanAAge")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam("age")Integer age){
       List<User> user=userService.getAllUserGreaterThan(age);
       return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}