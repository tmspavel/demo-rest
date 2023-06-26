package com.tms.demorest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import com.tms.demorest.dto.PersonDto;
import com.tms.demorest.entity.Person;
import com.tms.demorest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class PersonServiceTestMockito2 {

    private PersonValidationService personValidationService;
    private PersonRepository personRepository;
    private PersonServiceMockito personService;

    @BeforeEach
    void setUp() {
        personValidationService = Mockito.mock(PersonValidationService.class);
        personRepository = Mockito.mock(PersonRepository.class);
        personService = new PersonServiceMockito(personValidationService, personRepository);
    }

    @Test
    void saveSuccess() {
    //Mockito.when(personRepository.findByUsernameAndPassword()).thenReturn()
    }

}
