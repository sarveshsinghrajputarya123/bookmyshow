 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Transformers;

import com.example.bookMyShow.Dtos.RequestDto.MovieEntryDto;
import com.example.bookMyShow.Models.Movie;

/**
 *
 * @author acer
 */
public class MovieTransformer {
    
    
    

    public static Movie convertDtoToEntity(MovieEntryDto movieEntryDto){

        Movie movie = Movie.builder().movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .rating(movieEntryDto.getRating()).releaseDate(movieEntryDto.getReleaseDate())
                .build();

        return movie;
    }
}
