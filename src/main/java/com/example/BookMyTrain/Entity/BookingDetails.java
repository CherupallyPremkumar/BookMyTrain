package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
public class BookingDetails {
    @Id
    String id;
    Date dateofTravel;
    String trainCode;
    TicketStatus status;
    @OneToOne
   JourneyDetails journeyDetails;
     @OneToMany
    List<Seat> seatList;
    @OneToOne
    UserInformation userInformation;

}
