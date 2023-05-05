package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Converter.StationConverter;
import com.example.BookMyTrain.Converter.TrainConvertr;
import com.example.BookMyTrain.Converter.UserEntityConerter;
import com.example.BookMyTrain.Dto.EntryBookData;
import com.example.BookMyTrain.Entity.*;
import com.example.BookMyTrain.Exception.TheTrainAsStarted;
import com.example.BookMyTrain.Repository.BookingDeatilsRep;
import com.example.BookMyTrain.Repository.TrainRep;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BookSerive {

    HashMap<UserInformation, List<Seat>> seatTypeHashMap =new HashMap<>();
    @Autowired
    TrainData trainData;
    @Autowired
    TrainRep trainRep;
    @Autowired
    BookingDeatilsRep bookingDeatilsrep;
    @Autowired
    TicketService ticketService;
    @Autowired
    SeatsService seatsService;

    public TicketInformation bookTrain(EntryBookData entryBookData) throws TheTrainAsStarted {
        UserInformation userInformatio = UserEntityConerter.DtoToUser(entryBookData.getUserInformation());
        Train train = TrainConvertr.DtoToEntity(entryBookData.getTrain());
        train.setId(UUID.randomUUID().toString());
        train.setSeatList(seatsService.getAllSeats());
        train.setSourceStation(StationConverter.DtoToEntity(entryBookData.getTrain().getSourceStation()));
        train.setDestinationStation(StationConverter.DtoToEntity(entryBookData.getTrain().getDestinationStation()));
        JourneyDetails s = entryBookData.getJourneyDetails();
        List<Seat> seatList = entryBookData.getSeatList();
        ///check weather train is going that way by passing journey details
        Double TotalCost = 0d;
        if (!trainData.checktrainValidation(train, s)) {
            throw new TheTrainAsStarted("sss");
        }
        String id = null;
        TotalCost = CalculatetheTotalprice(seatList);
        if (checkSeatsAvailable(train, seatList, userInformatio).toString().equals("CONFIRMED")) {
            id = createBookingDetailsObject(seatList, s, userInformatio, train);
            return ticketService.createTicketObject(seatList, s, userInformatio, train, id, TicketStatus.CONFIRMED, TotalCost);
        } else {

            return ticketService.createTicketObject(seatList, s, userInformatio, train, id, TicketStatus.WAITINGLIST, TotalCost);
        }
    }

    private Double CalculatetheTotalprice(@NonNull List<Seat> seatList) {
        double total_cost = 0d;
        //calculating the total cost for indiidal
        for (Seat s : seatList) {
            if (s.getTypeOfSeat().equals(SeatType.General.toString())) {
                total_cost += s.getPriceofSeat();
            } else if (s.getTypeOfSeat().equals(SeatType.AC.toString())) {
                total_cost += s.getPriceofSeat();
            }
            else if (s.getTypeOfSeat().equals(SeatType.Sleeper.toString())) {
                total_cost += s.getPriceofSeat();
            } else {
                total_cost += s.getPriceofSeat();
            }
        }
        return total_cost;
    }

    private String createBookingDetailsObject(List<Seat> seatList, JourneyDetails s, UserInformation userInformatio, Train departureTime) {

        String id = UUID.randomUUID().toString();
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setJourneyDetails(s);
        bookingDetails.setId(id);
        bookingDetails.setSeatList(seatList);
        bookingDetails.setDateofTravel(departureTime.getTravelDate());
        bookingDetails.setTrainCode(departureTime.getTrainCode());
        bookingDetails.setStatus(TicketStatus.CONFIRMED);
        bookingDeatilsrep.save(bookingDetails);
        return id;
    }

    private TicketStatus checkSeatsAvailable(Train train, List<Seat> seatList, UserInformation userInformation) {
        //checking wheather ten seats aee booked or not
        TicketStatus status = null;
        for (Seat seat : train.getSeatList()) {
            if (!seat.isTaken()) {
                seatTypeHashMap.put(userInformation, seatList);
                status = TicketStatus.WAITINGLIST;
                break;
            }
        }
        if (checktheStatusOfTickets(status)) {
            for (Seat s : seatList) {
                s.setTaken(true);
            }
          //  trainRep.save(train);
            return TicketStatus.CONFIRMED;
        } else {
            return TicketStatus.WAITINGLIST;
        }
    }

    private boolean checktheStatusOfTickets(TicketStatus status) {
        if (status == null) {
            return true;
        }
        return status.toString().equals("CONFIRMED");
    }
}
