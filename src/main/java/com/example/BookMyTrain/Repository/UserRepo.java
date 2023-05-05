package com.example.BookMyTrain.Repository;

import com.example.BookMyTrain.Entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserRepo  extends JpaRepository<UserInformation,String> {
}
