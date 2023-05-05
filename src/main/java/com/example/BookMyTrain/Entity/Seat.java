package com.example.BookMyTrain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Seat {
    @Id
    String id;

    String typeOfSeat;
    int priceofSeat;
    boolean Taken;
    @ManyToOne
    Train train;
    @ManyToOne
    BookingDetails bookingDetails;
    @ManyToOne
    TicketInformation ticketInformation;

    public Seat(String id, String typeOfSeat, int priceofSeat, boolean taken) {
        this.id = id;
        this.typeOfSeat = typeOfSeat;
        this.priceofSeat = priceofSeat;
        Taken = taken;
    }
}
