package com.code.member;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

//@Component
//public class MemberMapper {
//    // MemberPostDTO 를 Member 로 변환
//    public Member memberPostDTOtoMember(MemberPostDTO memberPostDTO) {
//        return new Member(0L,
//                memberPostDTO.getEmail(),
//                memberPostDTO.getName(),
//                memberPostDTO.getPhone());
//    }
//    // MemberPatchDTO 를 Member 로 변환
//    public Member memberPatchDTOtoMember(MemberPatchDTO memberPatchDTO) {
//        return new Member(memberPatchDTO.getMemberId(),
//                null,
//                memberPatchDTO.getName(),
//                memberPatchDTO.getPhone());
//    }
//    // Member 를 MemberResponseDTO 로 변환
//    public MemberResponseDTO memberToMemberResponseDTO(Member member) {
//        return new MemberResponseDTO(member.getMemberId(),
//                member.getEmail(),
//                member.getName(),
//                member.getPhone());
//    }

// MapStruct 기반의 MemberMapper 인터페이스 정의
@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDTOtoMember(MemberPostDTO memberPostDTO);
    Member memberPatchDTOtoMember(MemberPatchDTO memberPatchDTO);
    MemberResponseDTO memberToMemberResponseDTO(Member member);
}
