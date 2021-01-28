package com.example.mysql;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private final PersonRepository repository;
    private final CarRepository carRepository;

    @GetMapping
    public List<Person> getAllPersons() {
        Iterable<Person> all = repository.findAll();
        return new ArrayList<>((Collection<? extends Person>) all);
    }

    @GetMapping("/{id}")
    public Optional<Person> findPersonById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping("/firstName")
    public List<Person> findPersonsByFirstNameLike(@RequestParam("firstName") String firstName) {
        return repository.findByFirstNameStartingWith(firstName);
    }

//    @PutMapping("/firstName/{id}/{name}")
//    public Boolean updateAge(@PathVariable("id") String id, @PathVariable("name") String name) {
//        return repository.updateFirstName(id, name);
//    }

    /**
     * @param pageable ?page=0&size=2&sort=id,desc
     * @return Page body
     */
    @GetMapping("/page")
    public Page<Person> getPersonsByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return repository.save(person);
    }


//    @GetMapping("/view/{id}")
//    public PersonVO getPersonVO(@PathVariable("id") String id){
//        return repository.findPersonById(id);
//    }

    @GetMapping("/car/{id}")
    public CarVO getCardView(@PathVariable("id") String personId) {
        Optional<Person> optionalPerson = repository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            List<Car> cars = carRepository.findByPersonId(personId);
            CarVO carVO = new CarVO();
            carVO.setId(personId);
            carVO.setFirstName(person.getFirstName());
            carVO.setLastName(person.getLastName());
            carVO.setCarList(cars);
            return carVO;
        } else {
            throw new IllegalArgumentException("person not found");
        }
    }

    @PostMapping("/transaction")
    public void updateTest(@RequestBody Person person) {
        transactionTest(person);
    }

    //    @Transactional
    public void transactionTest(Person person) {
        Person save = repository.save(person);
        try {
            Thread.sleep(40000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        save.setAge(save.getAge() + 1);
        repository.save(save);
    }
}
