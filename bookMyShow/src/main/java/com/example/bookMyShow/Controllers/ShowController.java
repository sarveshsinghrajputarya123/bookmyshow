/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Controllers;

import com.example.bookMyShow.Dtos.RequestDto.AddShowDto;
import com.example.bookMyShow.Dtos.RequestDto.ShowSeatsDto;
import com.example.bookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;
    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody AddShowDto addShowDto){
        try{
         String result=showService.addShow(addShowDto);
         return new ResponseEntity<>(result,HttpStatus.CREATED);
        }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/associate-seats")
    public ResponseEntity<String> associateSeats(@RequestBody ShowSeatsDto showSeatsDto){
        try{
            String result=showService.associateShowSeats(showSeatsDto);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/most-recommended-movie-name")
    public String getMovieName(AddShowDto addShowDto){
        return showService.getMovieName(addShowDto);
    }

}