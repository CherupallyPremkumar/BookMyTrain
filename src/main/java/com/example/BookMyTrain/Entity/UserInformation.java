package com.example.BookMyTrain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    @Id
    String id;
    String name;
    String contactNo;
    String panCard;
    String userName;
    String password;
}
