package com.example.BookMyTrain.Converter;

import com.example.BookMyTrain.Dto.EntryStation;
import com.example.BookMyTrain.Entity.Station;

public class StationConverter {
   public static Station DtoToEntity(EntryStation entryStation)
   {
      return Station.builder().stationCode(entryStation.getId()).build();
   }
}
