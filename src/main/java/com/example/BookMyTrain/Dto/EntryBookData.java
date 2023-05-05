package com.example.BookMyTrain.Dto;

import com.example.BookMyTrain.Entity.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Setter

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EntryBookData {
    EntryUserDto userInformation;
    JourneyDetails journeyDetails;
    List<Seat> seatList;
    EntryTrain train;


}
