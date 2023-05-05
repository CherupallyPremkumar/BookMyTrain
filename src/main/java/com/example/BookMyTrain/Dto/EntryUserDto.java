package com.example.BookMyTrain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryUserDto {
    String name;
    String contactNo;
    String panCard;
    String userName;
    String password;
}
