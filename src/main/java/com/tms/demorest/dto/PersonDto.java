package com.tms.demorest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonDto {

    private String username;
    private String password;
    private Boolean isAdmin;
    private Integer age;
}
