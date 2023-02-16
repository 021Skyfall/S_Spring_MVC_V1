package com.code.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberPostDTO {
    @NotBlank(message = "이메일 주소에 공백이 포함되지 않아야 합니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;
    @NotBlank(message = "이름에 공백 포함되지 않아야 합니다.")
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하고 11자리 숫자이며 '-'로 구성되어야 합니다.")
    private String phone;
}
