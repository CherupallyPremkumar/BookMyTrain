package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Entity.JourneyDetails;
import com.example.BookMyTrain.Entity.Train;
import com.example.BookMyTrain.Exception.TheTrainAsStarted;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@Service
public class TrainData {

    public Boolean checktrainValidation(Train train, JourneyDetails s) throws TheTrainAsStarted {
        if (train.getDepartureTime().compareTo(LocalTime.now()) > 0)
            throw new TheTrainAsStarted("the train hAs Started");
        if (!train.getSourceStation().getStationCode().equals(s.getSourceStation().getStationCode()) && !train.getDestinationStation().getStationCode().equals(s.getDestinationStation().getStationCode()))
            return false;
        return train.getSourceStation().getStationCode().equals(s.getDepartureStation().getStationCode());


    }
}
