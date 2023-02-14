package com.code.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
@Validated
public class MemberController {
    // 회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {
        System.out.println("# email: "+memberPostDTO.getEmail());
        System.out.println("# name: "+memberPostDTO.getName());
        System.out.println("# Phone: "+memberPostDTO.getPhone());

        return new ResponseEntity<>(memberPostDTO, HttpStatus.CREATED);
    }

    // 회원 정보 부분 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO) {
        memberPatchDTO.setMemberId(memberId);
        memberPatchDTO.setName("아무개");

        return new ResponseEntity<>(memberPatchDTO,HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId : "+memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 전체 회원 조히
    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

// 코드가 갈 수록 지저분해져서 
// 어차피 블로그에 과정 전부 작성했으니
// 앞으로 레거시 코드는 지움
// 다른 모든 객체도 마찬가지
// 단, 수정 시 블로깅을 위해 주석처리는 냅두고 이후 단계로 넘어가게되면 삭제