/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.bookMyShow.Repository;

import com.example.bookMyShow.Models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author acer
 */

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from users where age >= :value",nativeQuery=true)
    List<User> findUserWithAgeGreater(Integer value);
    //This is a custom function that you have defined
    //You need to write a query on top of this

}