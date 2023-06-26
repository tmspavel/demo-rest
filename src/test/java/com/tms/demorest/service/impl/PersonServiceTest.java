package com.tms.demorest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.tms.demorest.dto.PersonDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    private PersonService personService = new PersonService(new PersonValidationService());
    private PersonDto personDto;

    @BeforeEach
    void setUp() {
        personDto = PersonDto.builder()
                             .username("test")
                             .build();
    }

    @AfterEach
    void tearDown() {

    }

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @Test
    @Disabled
//    @RepeatedTest(10)
    void saveSuccess() {
//        //given(дано)
//        PersonDto personDto = PersonDto.builder()
//                                       .username("test")
//                                       .build();

        //when(то что будем тестировать)
        PersonDto saved = personService.save(personDto);

        //then(те результаты которые мы получим)
        assertNotNull(saved);
        assertEquals("test", saved.getUsername());
    }


    @Test
//    @RepeatedTest(10)
    void saveSuccess2() {
        PersonDto personDto = PersonDto.builder()
                                       .username("test")
                                       .build();

        PersonDto saved = personService.save(personDto);

        assertNotNull(saved);
        assertEquals("test", saved.getUsername());
    }



    @Test
    void savePersonIsNull() {
        assertThrows(IllegalArgumentException.class, () -> personService.save(null));
    }
}
