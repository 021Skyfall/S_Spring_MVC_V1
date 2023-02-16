package com.code.member.controller;

import com.code.member.entity.Member;
import com.code.member.mapper.MemberMapper;
import com.code.member.service.MemberService;
import com.code.member.dto.MemberPatchDTO;
import com.code.member.dto.MemberPostDTO;
import com.code.member.dto.MemberResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/members")
@Validated
@AllArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    // 회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDTO memberPostDTO) {
        // 매퍼를 사용해서 MemberPostDTO 를 Member 로 변환
        Member member = mapper.memberPostDTOtoMember(memberPostDTO);
        Member response = memberService.createMember(member);
        // 매퍼를 사용해서 Member 를 MemberResponseDTO 로 변환
        return new ResponseEntity<>(mapper.memberToMemberResponseDTO(response), HttpStatus.CREATED);
    }

    // 회원 정보 부분 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Min(1) long memberId,
                                      @Valid @RequestBody MemberPatchDTO memberPatchDTO) {
        memberPatchDTO.setMemberId(memberId);

        Member response = memberService.updateMember(mapper.memberPatchDTOtoMember(memberPatchDTO));

        return new ResponseEntity<>(mapper.memberToMemberResponseDTO(response),HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(mapper.memberToMemberResponseDTO(response),HttpStatus.OK);
    }

    // 전체 회원 조회
    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        // 매퍼를 사용해서 List<Member>를 MemberResponseDTO 로 변환
        List<MemberResponseDTO> response = members.stream()
                .map(mapper::memberToMemberResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        memberService.deleteMember();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

// 코드가 갈 수록 지저분해져서 
// 어차피 블로그에 과정 전부 작성했으니
// 앞으로 레거시 코드는 지움
// 다른 모든 객체도 마찬가지
// 단, 수정 시 블로깅을 위해 주석처리는 냅두고 이후 단계로 넘어가게되면 삭제