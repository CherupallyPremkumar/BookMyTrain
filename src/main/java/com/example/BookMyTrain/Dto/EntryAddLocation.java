package com.example.BookMyTrain.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EntryAddLocation {
    double latitude;
    double longitude;
}
