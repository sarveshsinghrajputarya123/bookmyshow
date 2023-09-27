/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Dtos.RequestDto;

import com.example.bookMyShow.Enums.Genre;
import com.example.bookMyShow.Enums.Language;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author acer
 */

@Data
public class MovieEntryDto {

    private String movieName;
    private double duration;
    private double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;

}