/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Dtos.RequestDto;

import lombok.Data;

/**
 *
 * @author acer
 */
@Data
public class TheaterSeatsEntryDto {

    private int noOfSeatsIn1Row;
    private int nofOfClassicSeats;
    private int noOfPremiumSeats;
    private String location;
}