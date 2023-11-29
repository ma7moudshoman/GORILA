package com.example.gorilla.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {

    private Long id;

    private String Firstname;

    private String Lastname;

    private  String Email;

    private Date Date;

    private LocalDate firstDate;

    private LocalDate endDate;

    private  String price;



}
