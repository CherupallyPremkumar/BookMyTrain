package com.example.BookMyTrain.Repository;

import com.example.BookMyTrain.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepo extends JpaRepository<Seat,String> {
}
