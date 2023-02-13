package com.code.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId) {
        Map<Object,Object> map = new LinkedHashMap<>();
        map.put("memberId",memberId);
        map.put("coffeeId",coffeeId);
        System.out.println("# memberId : " + memberId);
        System.out.println("# coffeeId : " + coffeeId);

        return new ResponseEntity(map, HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId : " + orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        System.out.println("# get Orders");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
