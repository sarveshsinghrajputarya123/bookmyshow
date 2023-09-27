/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Controllers;

import com.example.bookMyShow.Dtos.RequestDto.MovieEntryDto;
import com.example.bookMyShow.Services.MovieService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

     try {
         String result= movieService.addMovie(movieEntryDto);
         return new ResponseEntity<>(result,HttpStatus.CREATED);
     }catch (Exception e){
          return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
     }
    }

    @GetMapping("/totalCollection/{movieId}")
    public ResponseEntity<Long> totalCollection(@PathVariable Integer movieId) {
        try {
            Long result = movieService.totalCollection(movieId);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

}