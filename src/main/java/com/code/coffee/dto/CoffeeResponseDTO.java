package com.code.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoffeeResponseDTO {
    private long coffeeId;
    private String engName;
    private String korName;
    private int price;
}
