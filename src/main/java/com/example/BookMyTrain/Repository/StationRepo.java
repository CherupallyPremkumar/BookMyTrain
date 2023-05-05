package com.example.BookMyTrain.Repository;

import com.example.BookMyTrain.Entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepo extends JpaRepository<Station,String> {
}
