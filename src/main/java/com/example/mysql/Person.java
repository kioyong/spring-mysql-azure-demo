package com.example.mysql;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;

}
