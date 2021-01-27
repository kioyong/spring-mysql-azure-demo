package com.example.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {

    List<Car> findByPersonId(String personId);
}
