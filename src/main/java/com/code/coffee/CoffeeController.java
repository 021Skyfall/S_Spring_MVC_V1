package com.code.coffee;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/coffees")
@Validated
@AllArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDTO coffeePostDTO) {

//        // DI 활용 후 Service 계층과 연동
//        coffee.setEngName(coffeePostDTO.getEngName());
//        coffee.setKorName(coffeePostDTO.getKorName());
//        coffee.setPrice(coffeePostDTO.getPrice());

        // Mapper 적용 -> CoffeePostDTO 를 Coffee 로 변환 -> 요청 데이터
        // 서비스 계층과 연동한 후 서비스 로직을 실행 시킴
        Coffee response = coffeeService.createCoffee(mapper.coffeePostDTOtoCoffee(coffeePostDTO));

//        return new ResponseEntity<>(response, HttpStatus.CREATED);
        // Coffee 를 CoffeeResponseDTO 로 변환 -> 응답 데이터
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDTO(response),HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDTO coffeePatchDTO) {
        coffeePatchDTO.setCoffeeId(coffeeId);

//        // DI 활용 후 Service 계층과 연동
//        coffee.setCoffeeId(coffeePatchDTO.getCoffeeId());
//        coffee.setEngName(coffeePatchDTO.getEngName());
//        coffee.setKorName(coffeePatchDTO.getKorName());
//        coffee.setPrice(coffeePatchDTO.getPrice());

        // Mapper 적용 -> CoffeePatchDTO 를 Coffee 로 변환 -> 요청 데이터
        // 서비스 계층과 연동한 후 서비스 로직을 실행 시킴
        Coffee response = coffeeService.updateCoffee(mapper.coffeePatchDTOtoCoffee(coffeePatchDTO));

//        return new ResponseEntity<>(response,HttpStatus.OK);
        // Coffee 를 CoffeeResponseDTO 로 변환 -> 응답 데이터
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDTO(response),HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId) {

        // 비지니스 로직 실행
        Coffee response = coffeeService.findCoffee(coffeeId);
        // 마찬가지로 응답 데이터, 즉, Coffee 를 CoffeeResponseDTO 로 변환
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDTO(response),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        // 비지니스 로직 실행
        List<Coffee> coffees = coffeeService.findCoffees();
        // 리스트 형태인 응답 coffee 데이터를 리스트 형태 CoffeeResponseDTO 로 변환
        List<CoffeeResponseDTO> response = coffees.stream()
                        .map(mapper::coffeeToCoffeeResponseDTO)
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // 비지니스 로직 실행
        coffeeService.deleteCoffee();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
