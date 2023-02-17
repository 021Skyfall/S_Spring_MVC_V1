package com.code.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "회원이 없습니다."),
    DELETE_FAIL(500,"서버 문제로 삭제에 실패했습니다."),
    PATCH_FAIL(405,"회원 수정이 실패했습니다.");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
