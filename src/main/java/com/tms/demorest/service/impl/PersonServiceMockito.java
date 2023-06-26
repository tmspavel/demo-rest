package com.tms.demorest.service.impl;

import com.tms.demorest.dto.PersonDto;
import com.tms.demorest.entity.Person;
import com.tms.demorest.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonServiceMockito {

    private final PersonValidationService validator;
    private final PersonRepository personRepository;

    public PersonDto save(PersonDto personDto) {
        if (validator.isValid(personDto)) {
            System.out.println("Saved");
            Person entity = new Person();
            entity.setUsername(personDto.getUsername());
            Person savedEntity = personRepository.save(entity);
            return PersonDto.builder()
                            .username(savedEntity.getUsername())
                            .build();
        }
        throw new IllegalArgumentException();
    }

    public void save(String name) {
        Person person = new Person();
        person.setUsername(name);
        person.setIsAdmin(false);

        if (name != null) {
            personRepository.save(person);
        }
    }
}
