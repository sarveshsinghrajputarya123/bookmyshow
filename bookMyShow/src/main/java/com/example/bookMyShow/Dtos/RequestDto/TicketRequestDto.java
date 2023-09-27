/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Dtos.RequestDto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author acer
 */
 
@Data
public class TicketRequestDto {

    private int showId;
    private int userId;
    private List<String> requestedSeats;


}