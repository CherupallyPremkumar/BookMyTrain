package com.example.BookMyTrain.Controller;

import com.example.BookMyTrain.Dto.EntryBookData;
import com.example.BookMyTrain.Dto.EntryTrain;
import com.example.BookMyTrain.Dto.EntryUserDto;
import com.example.BookMyTrain.Entity.TicketInformation;
import com.example.BookMyTrain.Entity.UserInformation;
import com.example.BookMyTrain.Exception.TheTrainAsStarted;
import com.example.BookMyTrain.Service.BookSerive;
import com.example.BookMyTrain.Service.TrainService;
import com.example.BookMyTrain.Service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SingleController {
    @Autowired
    UserInfo userInfo;
    @Autowired
    BookSerive bookSerive;
    @Autowired
    TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody EntryUserDto entryUserDto)
    {
        userInfo.addUser(entryUserDto);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserInformation>> getAllUser()
    {

        return new ResponseEntity<>(userInfo.getAllUser(), HttpStatus.CREATED);
    }
    @PostMapping("/addLocation")
    public ResponseEntity<String> addLocation(@RequestBody EntryUserDto entryUserDto)
    {
        userInfo.addUser(entryUserDto);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
    @PostMapping("/bookTrain")
    public ResponseEntity<TicketInformation> bookTrain(@RequestBody EntryBookData entryBookData) throws TheTrainAsStarted {

        return new ResponseEntity<>(bookSerive.bookTrain(entryBookData), HttpStatus.CREATED);
    }
    @PostMapping("/addTrain")
    public ResponseEntity<String> addTrain(@RequestBody EntryTrain entryTrain)
    {
        trainService.addTrain(entryTrain);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
}
