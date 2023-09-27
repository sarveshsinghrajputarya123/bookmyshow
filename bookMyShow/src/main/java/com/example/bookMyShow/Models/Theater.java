/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author acer
 */


@Entity
@Table(name = "theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String location;


    //Keeping in mind the parent class
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
