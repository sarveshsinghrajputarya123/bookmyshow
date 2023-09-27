/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.AddShowDto;
import com.example.bookMyShow.Models.Show;

/**
 *
 * @author acer
 */
public class ShowTransformer {
    
    
     public static Show convertDtoToEntity(AddShowDto addShowDto){

        Show show = Show.builder().time(addShowDto.getShowStartTime())
                .date(addShowDto.getShowDate()).build();

        return show;

    }
}
