package com.code.member;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberPostDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "이름에 공백 불가")
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하고 11자리 숫자이며 '-'로 구성되어야 합니다.")
    private String phone;
}
