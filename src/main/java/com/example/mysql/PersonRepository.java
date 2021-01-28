package com.example.mysql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
    Page<Person> findAll(Pageable pageable);

    List<Person> findByFirstNameStartingWith(String firstName);

//    @Modifying
//    @Query("update person set first_name = :name where id = :id")
//    boolean updateFirstName(@Param("id") String id, @Param("name") String name);


//    @Query("select id,first_name from person p where p.id = :id")
//    PersonVO findPersonById(@Param("id") String id);
}
