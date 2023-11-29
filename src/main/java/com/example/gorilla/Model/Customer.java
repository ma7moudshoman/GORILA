package com.example.gorilla.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String FirstName;
    private String Lastname;
    private String Email;
    private  String Date;
    private  String price;


}
