package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Station {
    @Id
    String id;
    String station_Name;
    String stationCode;
    @OneToOne
    Location location;
    String stationAddress;


}
