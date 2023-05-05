package com.example.BookMyTrain.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Id
    String id;
    String trainCode;
    String trainName;
    @OneToOne
    Station sourceStation;
    @OneToOne
    Station destinationStation;
    @JsonFormat(pattern = "hh:mm:ss")
    LocalTime departureTime;
    @JsonFormat( pattern = "yyyy-MM-dd")
    Date travelDate;
    @JsonFormat(pattern = "hh:mm:ss")
    LocalTime arrivalTime;
    @JsonFormat(pattern = "ss")
    Duration durationOfTheJourney;
   @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    List<Seat> seatList;


}
