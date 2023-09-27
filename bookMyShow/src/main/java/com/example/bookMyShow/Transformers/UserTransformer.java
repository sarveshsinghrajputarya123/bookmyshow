/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.AddUserDto;
import com.example.bookMyShow.Dtos.ResponseDtos.UserResponseDto;
import com.example.bookMyShow.Models.User;

/**
 *
 * @author acer
 */
public class UserTransformer {
    
    
    public static User convertDtoToEntity(AddUserDto userDto){

        User userObj = User.builder().age(userDto.getAge()).email(userDto.getEmailId()).mobNo(userDto.getMobNo())
                .name(userDto.getName()).build();
        return userObj;
    }

    public static UserResponseDto convertEntityToDto(User user){

        UserResponseDto userResponseDto = UserResponseDto.builder().age(user.getAge()).name(user.getName())
                .mobNo(user.getMobNo()).build();
        return userResponseDto;
    }
}
