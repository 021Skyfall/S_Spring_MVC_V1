package com.code.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDTO {
    @Pattern(regexp = "^[a-zA-Z](\\s?[a-zA-Z])*$")
    private String engName;
    @Pattern(regexp = "^[가-힣]+$")
    private String korName;
    @Range(min = 1000,max = 50000)
    private Integer price;
}
