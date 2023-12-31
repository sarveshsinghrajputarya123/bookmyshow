/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bookMyShow.Services;

import com.example.bookMyShow.Dtos.RequestDto.TicketRequestDto;
import com.example.bookMyShow.Dtos.ResponseDtos.TicketResponseDto;
import com.example.bookMyShow.Exception.NoUserFoundException;
import com.example.bookMyShow.Exception.ShowNotFound;
import com.example.bookMyShow.Models.Show;
import com.example.bookMyShow.Models.ShowSeat;
import com.example.bookMyShow.Models.Ticket;
import com.example.bookMyShow.Models.User;
import com.example.bookMyShow.Repository.ShowRepository;
import com.example.bookMyShow.Repository.TicketRepository;
import com.example.bookMyShow.Repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acer
 */

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketRepository ticketRepository;



    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto)throws NoUserFoundException, ShowNotFound,Exception {

        //User validation
        int userId = ticketRequestDto.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new NoUserFoundException("User Id is incorrect");
        }

        //Show Validation
        int showId = ticketRequestDto.getShowId();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new ShowNotFound("Show is not found");
        }
        Show show = showOptional.get();

        //Validation for the requested Seats are available or not
        boolean isValid = validateShowAvailability(show,ticketRequestDto.getRequestedSeats());

        if(!isValid){
            throw new Exception("Requested Seats entered are not available");
        }

        Ticket ticket = new Ticket();
        //calculate the total price

        int totalPrice = calculateTotalPrice(show,ticketRequestDto.getRequestedSeats());

        ticket.setTotalTicketsPrice(totalPrice);

        //Convert the list of booked seats into string from list
        String bookedSeats = convertListToString(ticketRequestDto.getRequestedSeats());

        ticket.setBookedSeats(bookedSeats);
        //Do bidirectional mapping

        User user = userOptional.get();

        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        //Saving the relevant repositories

        userRepository.save(user);

        show.getTicketList().add(ticket);

        showRepository.save(show);

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        String body="Hi"+user.getName()+" ! /n "+
             "You have successfully booked a ticket. Please find the following details No's"+ bookedSeats
              +"movie Name"+ show.getMovie().getMovieName()
              +"show Date is"+show.getDate()+
              "And show time is "+show.getTime()+
              "Enjoy the show!!! "+show.getTime()+
              "Enjoy the show !!!";

        simpleMailMessage.setSubject("Ticket confirmation Mail");
        simpleMailMessage.setFrom("aimofficer1963@gmail.com");
        simpleMailMessage.setText(body);
        simpleMailMessage.setTo(user.getEmail());

        return createTicketReponseDto(show,ticket);
    }
    private boolean validateShowAvailability(Show show, List<String> requestedSeats){

        List<ShowSeat> showSeatList = show.getShowSeatList();
        for(ShowSeat showSeat : showSeatList){
            String seatNo = showSeat.getSeatNo();
            if(requestedSeats.contains(seatNo)){
                if(showSeat.isAvailable()==false)
                    return false;
            }
        }
        return true;
    }


    private int calculateTotalPrice(Show show, List<String> requestedSeats){
        int totalPrice = 0;
        List<ShowSeat> showSeatList = show.getShowSeatList();
        for(ShowSeat showSeat : showSeatList){
            if(requestedSeats.contains(showSeat.getSeatNo())){
                totalPrice = totalPrice + showSeat.getPrice();
                showSeat.setAvailable(false);
            }
        }
        return totalPrice;
    }

    String convertListToString(List<String> seats){
        String result = "";
        for(String seatNo : seats){
            result = result + seatNo+", ";
        }
        return result;
    }

    private TicketResponseDto createTicketReponseDto(Show show, Ticket ticket){
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .location(show.getTheater().getLocation())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getDate())
                .showTime(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();
        return ticketResponseDto;
    }
}
