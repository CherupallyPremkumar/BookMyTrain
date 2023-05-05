package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Lock;

@Entity

public class Location {
    @Id
    String id;
    double latitude;
    double longitude;
}
