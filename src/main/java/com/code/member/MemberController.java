package com.code.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")//, produces = {MediaType.APPLICATION_JSON_VALUE}) // produces 설정 제거
public class MemberController {
    @PostMapping
//    public String postMember(
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {
        // JSON 문자열 수작업을 Map 객체로 대체
        Map<String,String> map = new LinkedHashMap<>();
        map.put("email",email);
        map.put("name",name);
        map.put("Phone",phone);
        System.out.println("# email: "+email);
        System.out.println("# name: "+name);
        System.out.println("# Phone: "+phone);

//        String response =
//                "{\"" +
//                        "email\":\""+email+"\"," +
//                        "\"name\":\""+name+"\",\"" +
//                        "phone\":\"" + phone+
//                        "\"}";
//        return response;

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
//    public String getMember(@PathVariable("member-id")long memberId) {
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId : "+memberId);
//        return null;
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping
//    public String getMembers() {
    public ResponseEntity getMembers() {
        System.out.println("# get Members");
//        return null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
