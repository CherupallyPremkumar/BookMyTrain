package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketService {
    public TicketInformation createTicketObject(List<Seat> seatList, JourneyDetails s, UserInformation userInformatio, Train train,String id ,TicketStatus status,Double totalCost) {
        TicketInformation information=new TicketInformation();
        information.setBookingId(id);
        information.setTicketStatus(status);
        information.setJourneyDetails(s);
        information.setPrice(totalCost);
        information.setSeatList(seatList);
        return information;
    }
}
