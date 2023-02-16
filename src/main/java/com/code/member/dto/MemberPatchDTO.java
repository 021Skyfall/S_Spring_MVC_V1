package com.code.member.dto;

import com.code.member.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberPatchDTO {
    private long memberId;
    @NotSpace(message = "이름에 공백 포함되지 않아야 합니다.") // 커스텀 애너테이션 적용
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야합니다.")
    private String phone;
}
// 수정이니까 setter 도 필요
