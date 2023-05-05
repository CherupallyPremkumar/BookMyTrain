package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Entity.Seat;
import com.example.BookMyTrain.Repository.SeatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatsService {
    @Autowired
    SeatsRepo seatsRepo;

    public List<Seat> getAllSeats() {
        return seatsRepo.findAll();
    }
}
