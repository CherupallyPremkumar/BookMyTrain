package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JourneyDetails {
    @Id
    String id;
    @OneToOne
    Station sourceStation;
    @OneToOne
    Station destinationStation;
    @OneToOne
    Station departureStation;
    LocalTime arrivalTime;
}
