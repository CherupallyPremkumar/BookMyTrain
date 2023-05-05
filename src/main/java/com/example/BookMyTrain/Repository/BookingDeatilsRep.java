package com.example.BookMyTrain.Repository;

import com.example.BookMyTrain.Entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDeatilsRep extends JpaRepository<BookingDetails,String> {
}
