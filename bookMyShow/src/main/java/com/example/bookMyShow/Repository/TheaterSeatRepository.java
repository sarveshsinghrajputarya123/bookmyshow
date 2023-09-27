/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author acer
 */
public interface TheaterSeatRepository extends JpaRepository<TheaterSeat,Integer> {
}
