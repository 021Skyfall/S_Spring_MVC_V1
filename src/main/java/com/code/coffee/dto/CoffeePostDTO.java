package com.code.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDTO {
    @Pattern(regexp = "^[a-zA-Z](\\s?[a-zA-Z])*$",
            message = "영어로만 이루어져 있어야하며 문자 사이에만 공백 한 번 가능합니다.")
    private String engName;
    @Pattern(regexp = "^[가-힣]+$",
            message = "한글로만 이루어져 있어야 하며, 공백이 없어야 합니다.")
    private String korName;
    @Range(min = 1000,max = 50000,
            message = "가격은 1000 이상 50000 이하여야 합니다.")
    private Integer price;
}
