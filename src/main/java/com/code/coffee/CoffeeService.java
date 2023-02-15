package com.code.coffee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    // 핸들러가 가진 기능 뺏어올 것임 -> 핸들러는 단순히 Request Body 를 전달받고 다시 응답하는 역할만 해야함
    // 커피 등록
    public Coffee createCoffee(Coffee coffee) {
        Coffee createCoffee = coffee;
        return createCoffee;
    }
    // 커피 수정
    public Coffee updateCoffee(Coffee coffee) {
        Coffee updateCoffee = coffee;
        return updateCoffee;
    }
    // 커피 조회
    public Coffee findCoffee(long coffeeId) {
        Coffee coffee = new Coffee(coffeeId,"Caffe Latte","카페라떼",4500);
        return coffee;
    }
    // 커피 전체 조회
    public List<Coffee> findCoffees() {
        List<Coffee> coffees = List.of(
                new Coffee(1, "Vanilla Latte", "바닐라라떼", 5000),
                new Coffee(2, "Americano", "아메리카노", 3000)
        );
        return coffees;
    }
    // 커피 삭제
    public void deleteCoffee(){}
}
