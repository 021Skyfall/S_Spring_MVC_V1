package com.code.member.service;

import com.code.exception.BusinessLogicException;
import com.code.exception.ExceptionCode;
import com.code.member.entity.Member;
import com.sun.source.tree.TryTree;
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
//        Member updatedMember = member;
//        return updatedMember;
        throw new BusinessLogicException(ExceptionCode.PATCH_FAIL);
    }

    // 멤버 조회
    public Member findMember(long memberId) {
        //데이터 베이스에 값이 있다고 가정
            Member member = new Member(1L, "asd@gamail.com", "David", "010-1111-2222");
            try {
                return member;
            } catch (Exception e) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
            }
        }

        // 전체 멤버 조회
        public List<Member> findMembers () {
            // member 객체는 나중에 DB에서 조회하는 것으로 변경 필요
            List<Member> members = List.of( // Stub
                    new Member(1L, "asd@gamail.com", "David", "010-1111-2222"),
                    new Member(2L, "qwe@naver.com", "Choi", "010-1234-1234")
            );
            return members;
        }
        // 멤버 삭제
        public void deleteMember () {

//        String logResult = null;
//        System.out.println(logResult.toUpperCase());
            throw new BusinessLogicException(ExceptionCode.DELETE_FAIL);
        }
    }
