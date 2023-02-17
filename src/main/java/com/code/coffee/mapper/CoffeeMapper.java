package com.code.coffee.mapper;

import com.code.coffee.dto.CoffeePatchDTO;
import com.code.coffee.dto.CoffeePostDTO;
import com.code.coffee.dto.CoffeeResponseDTO;
import com.code.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeeMapper {
    Coffee coffeePostDTOtoCoffee(CoffeePostDTO coffeePostDTO);
    Coffee coffeePatchDTOtoCoffee(CoffeePatchDTO coffeePatchDTO);
    CoffeeResponseDTO coffeeToCoffeeResponseDTO(Coffee coffee);

    List<CoffeeResponseDTO> coffeeToCoffeeResponseDTO(List<Coffee> coffee);

}
