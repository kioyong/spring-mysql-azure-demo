package com.example.mysql;

import lombok.Data;

import java.util.List;

@Data
public class CarVO {

    private String id;
    private String firstName;
    private String lastName;
    private List<Car> carList;
}

