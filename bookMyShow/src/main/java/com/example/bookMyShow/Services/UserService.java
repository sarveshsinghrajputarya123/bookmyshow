/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Services;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookMyShow.Exception.NoUserFoundException;
import com.example.bookMyShow.Models.User;
import com.example.bookMyShow.Repository.UserRepository;
import com.example.bookMyShow.Transformers.UserTransformer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserDto userDto)  {
        User user = UserTransformer.convertDtoToEntity(userDto);
        userRepository.save(user);
        return "User has been added successfully ";
    }

    public UserResponseDto getOldestUser()throws NoUserFoundException {
        //Prevent you from exposing the PK
        //Prevents Infinite recursion incase it occurs
        List<User> users = userRepository.findAll();
        Integer maxAge = 0;

        User userAns = null;

        for(User user: users)
        {
            if(user.getAge()>maxAge){
                maxAge = user.getAge();
                userAns = user;
            }
        }

        if(userAns==null){
            throw new NoUserFoundException("No user Found");
        }

        //We need to transform the UserEntity to the userResponse
        UserResponseDto userResponseDto = UserTransformer.convertEntityToDto(userAns);

        return userResponseDto;
    }

    public List<User> getAllUserGreaterThan(Integer age){

        List<User> users = userRepository.findUserWithAgeGreater(age);
        return users;

    }
}
