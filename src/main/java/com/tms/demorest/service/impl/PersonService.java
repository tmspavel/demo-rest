package com.tms.demorest.service.impl;

import com.tms.demorest.dto.PersonDto;
import com.tms.demorest.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonValidationService validator;

    public PersonDto save(PersonDto personDto) {
        if (validator.isValid(personDto)) {
            System.out.println("Saved");
            return personDto;
        }
        throw new IllegalArgumentException();
    }

}
