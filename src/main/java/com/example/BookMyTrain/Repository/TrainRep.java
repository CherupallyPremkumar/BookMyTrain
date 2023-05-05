package com.example.BookMyTrain.Repository;

import com.example.BookMyTrain.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRep extends JpaRepository<Train,String> {

}
