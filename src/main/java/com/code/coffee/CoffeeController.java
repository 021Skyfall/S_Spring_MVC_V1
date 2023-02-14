package com.code.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDTO coffeePostDTO) {
        return new ResponseEntity<>(coffeePostDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDTO coffeePatchDTO) {

        coffeePatchDTO.setCoffeeId(coffeeId);
        return new ResponseEntity<>(coffeePatchDTO,HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id")long coffeeId) {
        System.out.println("# coffeeId : "+coffeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
