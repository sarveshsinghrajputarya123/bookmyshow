/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.TheaterEntryDto;
import com.example.bookMyShow.Models.Theater;

/**
 *
 * @author acer
 */
public class TheaterTransformers {
    
    
    
    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        Theater theater = Theater.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();

        return theater;
    }

}
