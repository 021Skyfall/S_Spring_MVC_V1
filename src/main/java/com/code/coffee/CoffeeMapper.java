package com.code.coffee;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDTOtoCoffee(CoffeePostDTO coffeePostDTO);
    Coffee coffeePatchDTOtoCoffee(CoffeePatchDTO coffeePatchDTO);
    CoffeeResponseDTO coffeeToCoffeeResponseDTO(Coffee coffee);
}
