package com.code.member.service;

import com.code.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    // 멤버 등록
    public Member createMember(Member member) {
        // member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요
        Member createdMember = member;
        return createdMember;
    }
    // 멤버 수정
    public Member updateMember(Member member) {
        // member 객체는 나중에 DB에 업데이트 후, 되돌려 받는 것으로 변경 필요
        Member updatedMember = member;
        return updatedMember;
    }
    // 멤버 조회
    public Member findMember(long memberId) {
        // member 객체는 나중에 DB에서 조회 하는 것으로 변경 필요
        Member member = new Member(memberId,"asd@gmail.com","David","010-1111-2222"); // Stub
        return member;
    }
    // 전체 멤버 조회
    public List<Member> findMembers() {
        // member 객체는 나중에 DB에서 조회하는 것으로 변경 필요
        List<Member> members = List.of( // Stub
                new Member(1L,"asd@gamail.com","David","010-1111-2222"),
                new Member(2L, "qwe@naver.com","Choi","010-1234-1234")
        );
        return members;
    }
    // 멤버 삭제
    public void deleteMember(){}
}
