package com.example.BookMyTrain.Converter;

import com.example.BookMyTrain.Dto.EntryTrain;
import com.example.BookMyTrain.Entity.Train;

public class TrainConvertr {
    public static Train DtoToEntity(EntryTrain entryTrain) {
        return Train.builder().trainCode(entryTrain.getTrainCode())
                .arrivalTime(entryTrain.getArrivalTime())
                .departureTime(entryTrain.getDepartureTime())
                .durationOfTheJourney(entryTrain.getDurationOfTheJourney())
                .trainName(entryTrain.getTrainName())
                .travelDate(entryTrain.getTravelDate())
                .build();
    }

}
