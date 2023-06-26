package com.tms.demorest.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.tms.demorest.dto.PersonDto;
import com.tms.demorest.entity.Person;
import com.tms.demorest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class PersonServiceTestMockito {

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
        //given(дано)
        PersonDto personDto = PersonDto.builder()
                                       .username("test")
                                       .build();

        //when(то что будем тестировать)
        Mockito.when(personValidationService.isValid(personDto)).thenReturn(true);
//        Mockito.when(personValidationService.isValid(personDto)).thenCallRealMethod();
        Person person = new Person();
        person.setUsername("test");

        Mockito.when(personRepository.save(any())).thenReturn(person);
        PersonDto saved = personService.save(personDto);

        //then(те результаты которые мы получим)
        assertNotNull(saved);
        assertEquals("test", saved.getUsername());
    }

    @Test
    void savePersonIsNotValid() {
        //given(дано)
        PersonDto personDto = PersonDto.builder()
                                       .username("test")
                                       .build();

        //when(то что будем тестировать)
        Mockito.when(personValidationService.isValid(personDto)).thenReturn(false);

        //when and then
        assertThrows(IllegalArgumentException.class, () -> personService.save(personDto));
    }

    @Test
    void testSaveByUserNameStoreInDb() {
        //given(дано)
        String name = "test";
        //when(то что будем тестировать)
        personService.save(name);

        //then

//        Mockito.verify(personRepository.save(any()), Mockito.atLeastOnce());
        verify(personRepository.save(any()), Mockito.times(1));

        verify(personRepository, Mockito.atLeastOnce()).save(any());
    }

    @Test
    void testSaveByUserNameWithRole() {
        //given(дано)
        var captor = ArgumentCaptor.forClass(Person.class);
        String name = "test";

        //when(то что будем тестировать)
        personService.save(name);

        //then
        verify(personRepository).save(captor.capture());

        Person value = captor.getValue();
        assertEquals(false, value.getIsAdmin());
        assertEquals(name, value.getUsername());
    }

    @Test
    void testSaveNoSavedIfUserNameIsNull() {
        String name = null;
        personService.save(name);
        verify(personRepository.save(any()), Mockito.times(0));
//        Mockito.verifyNoInteractions(personRepository);
    }
}
