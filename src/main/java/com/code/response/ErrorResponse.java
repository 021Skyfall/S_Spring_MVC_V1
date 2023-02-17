package com.code.response;

import com.code.exception.BusinessLogicException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private int status;
    private String message;
    private BusinessError businessError;
    private List<FieldError> fieldErrors; // (1)
    private List<ConstraintViolationError> violationErrors; // (2)

    // (4) BindingResult 에 대한 ErrorResponse 객체 생성
    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(0,null,null,FieldError.of(bindingResult), null);
    }
    //(5) Set<ConstraintViolation<?>> 객체에 대한 ErrorResponse 객체 생성
    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(0,null,null,null, ConstraintViolationError.of(violations));
    }
    public static ErrorResponse of(BusinessLogicException businessLogicException){
        return new ErrorResponse(0,null,BusinessError.of(businessLogicException),null,null);
    }
//    public static ErrorResponse of(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
//        return new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),null,null,null);
//    }
//
//    // 모든 런타임 에러를 처리하게 끔 변경(해봄)
//    public static ErrorResponse of(Exception e) {
//        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null,null,null);
//    }

    // Request Body 유효성 검증 // (6) Field Error 가공
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FieldError{
        private String field;
        private Object rejectedValue;
        private String reason;

        private static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    // URI 유효성 검증 // (7) ConstraintViolation Error 가공
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ConstraintViolationError{
        private String propertyPath;
        private String rejectedValue;
        private String reason;

        public static List<ConstraintViolationError> of(Set<ConstraintViolation<?>> constraintViolations) {

            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }

    // 위와 같은 묶음 처리 커스텀 익셉션 핸들링
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class BusinessError{
        private int status;
        private String message;

        public static BusinessError of(BusinessLogicException businessLogicException) {
            return new BusinessError(businessLogicException.getExceptionCode().getStatus(),
                    businessLogicException.getMessage());
        }
    }
}
