package com.example.mysql;

import lombok.Data;

@Data
public class PersonVO {
    private String id;
    private String firstName;

    public PersonVO(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
