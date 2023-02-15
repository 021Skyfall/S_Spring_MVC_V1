package com.code.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coffee {
    private long coffeeId;
    private String engName;
    private String korName;
    private Integer price;
}
