/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Dtos.ResponseDtos;

import java.time.LocalTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author acer
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {

    private String responseMessage;

    private LocalTime showTime;
    private Date showDate;

    private String movieName;

    private String theaterName;

    private String bookedSeats;

    private String location;

    private int totalPrice;

    public void setResponseMessage(String message) {
    }
}