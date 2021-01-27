package com.example.mysql;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    private String id;
    private String personId;
    private String carName;
}
