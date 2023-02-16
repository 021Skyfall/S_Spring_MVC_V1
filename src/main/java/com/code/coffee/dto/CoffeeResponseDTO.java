package com.code.coffee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoffeeResponseDTO {
    private long coffeeId;
    private String engName;
    private String korName;
    private Integer price;
}
