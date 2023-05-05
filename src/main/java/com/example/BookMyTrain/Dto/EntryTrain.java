package com.example.BookMyTrain.Dto;

import com.example.BookMyTrain.Entity.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EntryTrain {
    String trainCode;
    String trainName;
    EntryStation sourceStation;
    EntryStation destinationStation;
    LocalTime departureTime;
    Date travelDate;
    LocalTime arrivalTime;
    Duration durationOfTheJourney;
}
