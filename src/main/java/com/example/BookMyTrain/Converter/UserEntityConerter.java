package com.example.BookMyTrain.Converter;

import com.example.BookMyTrain.Dto.EntryUserDto;
import com.example.BookMyTrain.Entity.UserInformation;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class UserEntityConerter {

  public static UserInformation DtoToUser(EntryUserDto entryUserDto)
    {
        return  UserInformation.builder()
                .userName(entryUserDto.getUserName())
                .contactNo(entryUserDto.getContactNo())
                .panCard(entryUserDto.getPanCard())
                .name(entryUserDto.getName()).build();
    }
}
