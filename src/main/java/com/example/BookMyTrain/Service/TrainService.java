package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Converter.TrainConvertr;
import com.example.BookMyTrain.Dto.EntryTrain;
import com.example.BookMyTrain.Entity.Station;
import com.example.BookMyTrain.Entity.Train;
import com.example.BookMyTrain.Repository.StationRepo;
import com.example.BookMyTrain.Repository.TrainRep;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TrainService {
    @Autowired
    SeatsService seatsService;
    @Autowired
    TrainRep trainRep;
    @Autowired
    StationRepo stationRepo;

    public void addTrain(EntryTrain entryTrain) {
       Optional<Station> sorstation= stationRepo.findById(entryTrain.getSourceStation().getId());
       Optional<Station> desstation= stationRepo.findById(entryTrain.getDestinationStation().getId());
        if(sorstation.isEmpty()) throw new NullPointerException();
        if(desstation.isEmpty()) throw new NullPointerException();
        Train train=TrainConvertr.DtoToEntity(entryTrain);
        train.setSourceStation(sorstation.get());
        train.setDestinationStation(desstation.get());
        train.setId(UUID.randomUUID().toString());
        train.setSeatList(seatsService.getAllSeats());
        trainRep.save(train);
    }
}
