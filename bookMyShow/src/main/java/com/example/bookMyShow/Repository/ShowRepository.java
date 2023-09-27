/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Models.Show;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author acer
 */

public interface ShowRepository extends JpaRepository<Show,Integer> {

     @Query(value="select movie_id from shows group by movie_id order by count(*) desc limit 1;",nativeQuery=true)
     public Integer getMostShowedMovie(Date checkDate);

     @Query(value = "select * from shows where movie_id = :movieId",nativeQuery = true)
     public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);



}