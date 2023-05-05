package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class TicketInformation {
    @Id
    String bookingId;
    TicketStatus ticketStatus;
    Double price;
    @OneToMany
    List<Seat> seatList;
    @OneToOne
    JourneyDetails journeyDetails;
}
