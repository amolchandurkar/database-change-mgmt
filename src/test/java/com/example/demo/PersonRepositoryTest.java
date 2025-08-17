package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository.deleteAll();
    }

    @Test
    void testSaveAndFind() {
        Person person = new Person();
        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setEmailId("jane.smith@example.com");
        personRepository.save(person);

        List<Person> persons = personRepository.findAll();
        assertThat(persons).hasSize(1);
        assertThat(persons.get(0).getFirstName()).isEqualTo("Jane");
        assertThat(persons.get(0).getEmailId()).isEqualTo("jane.smith@example.com");
    }
}
