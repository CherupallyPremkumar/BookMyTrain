package com.example.BookMyTrain;

import com.example.BookMyTrain.Controller.SingleController;
import com.example.BookMyTrain.Converter.StationConverter;
import com.example.BookMyTrain.Dto.EntryBookData;
import com.example.BookMyTrain.Dto.EntryStation;
import com.example.BookMyTrain.Dto.EntryTrain;
import com.example.BookMyTrain.Dto.EntryUserDto;
import com.example.BookMyTrain.Entity.*;
import com.example.BookMyTrain.Exception.TheTrainAsStarted;
import com.example.BookMyTrain.Service.BookSerive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BookMyTrainApplicationTests {
    @Autowired
    BookSerive bookSerive;
    EntryStation entryStation = new EntryStation("HYD");
    EntryStation entryStation1 = new EntryStation("HYD");
    Station station = new Station();

    JourneyDetails journeyDetails = new JourneyDetails("dsd", StationConverter.DtoToEntity(entryStation), StationConverter.DtoToEntity(entryStation1), StationConverter.DtoToEntity(entryStation), LocalTime.now());
    EntryTrain train = new EntryTrain("VIT", "venkatadri", entryStation, entryStation1, LocalTime.now(), new Date(), LocalTime.MIN, Duration.ofHours(5));

    EntryUserDto userDto = new EntryUserDto("prem", "32456", "dfsadsad222", "premkumar.cherupally@gmail.com", "psjs");
    List<Seat> seatList = new ArrayList<>(Arrays.asList(new Seat("aaa", "Sleeper", 1000, false), new Seat("aa", "Sleeper", 100, false), new Seat("a", "Sleeper", 10, false)));
    EntryBookData entryBook = new EntryBookData(userDto, journeyDetails, seatList, train);


    @Test
    void testBookService() throws TheTrainAsStarted {
        TicketInformation ticketInformation = new TicketInformation();

        Assertions.assertEquals(ticketInformation, bookSerive.bookTrain(entryBook));
    }

    @Test
    void testBookServiceWaittingList() throws TheTrainAsStarted {
        TicketInformation ticketInformation = new TicketInformation();

        Assertions.assertEquals(ticketInformation, bookSerive.bookTrain(entryBook));
    }

    @Test
    void testAddStation() {
        TicketInformation ticketInformation = new TicketInformation();

        Assertions.assertEquals(ticketInformation, bookSerive.bookTrain(entryBook));
    }

}
