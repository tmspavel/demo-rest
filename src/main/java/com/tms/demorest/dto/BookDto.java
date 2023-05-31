package com.tms.demorest.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {

    private Long id;
    private String name;
//    @JsonProperty("desc")
    private String desc;

}
