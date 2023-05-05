package com.example.BookMyTrain.Service;

import com.example.BookMyTrain.Converter.UserEntityConerter;
import com.example.BookMyTrain.Dto.EntryUserDto;
import com.example.BookMyTrain.Entity.UserInformation;
import com.example.BookMyTrain.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.security.KeyStore;
import java.util.List;
import java.util.UUID;

@Service
public class UserInfo {

    @Autowired
    UserRepo userRepo;


    public void addUser(EntryUserDto entryUserDto) {
       UserInformation userInformation=UserEntityConerter.DtoToUser(entryUserDto);
       userInformation.setId(UUID.randomUUID().toString());
       userInformation.setPassword(entryUserDto.getPassword());
       userRepo.save(userInformation);
    }


    public List<UserInformation> getAllUser() {
        return userRepo.findAll();
    }
}
