package com.example.demo;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    void testPersonGettersSetters() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Alice");
        person.setLastName("Wonderland");
        person.setEmailId("alice@wonderland.com");

        assertThat(person.getId()).isEqualTo(1L);
        assertThat(person.getFirstName()).isEqualTo("Alice");
        assertThat(person.getLastName()).isEqualTo("Wonderland");
        assertThat(person.getEmailId()).isEqualTo("alice@wonderland.com");
    }

    @Test
    void testPersonNullFields() {
        Person person = new Person();
        assertThat(person.getId()).isNull();
        assertThat(person.getFirstName()).isNull();
        assertThat(person.getLastName()).isNull();
        assertThat(person.getEmailId()).isNull();
    }
}
