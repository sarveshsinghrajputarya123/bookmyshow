/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Dtos.RequestDto;

import java.time.LocalTime;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author acer
 */

@Data
public class AddShowDto {

    private LocalTime showStartTime;
    private Date showDate;
    private int theaterId;
    private int movieId;

}
