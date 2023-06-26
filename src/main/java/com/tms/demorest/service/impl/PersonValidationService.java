package com.tms.demorest.service.impl;

import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

import com.tms.demorest.dto.PersonDto;

public class PersonValidationService {

    public boolean isValid(PersonDto personDto) {
        if (isNull(personDto)) {
            return false;
        }

        if (isBlank(personDto.getUsername())) {
            return false;
        }
        return true;
    }

}
