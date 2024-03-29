package com.footprints.businessservice.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.security.SignatureException;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity handlerBaseException(BaseException exception) {
        log.error("BaseException errorMessage(): {}", exception.getExceptionType().getErrorMessage());
        log.error("BaseException errorCode(): {}", exception.getExceptionType().getErrorCode());

        return new ResponseEntity(new ExceptionDto(exception.getExceptionType().getErrorMessage()), exception.getExceptionType().getHttpStatus());
    }

    // @Valid 에서 예외 발생
    @ExceptionHandler(BindException.class)
    public ResponseEntity handleValidEx(BindException exception) {
        log.error("@ValidException 발생! {}", exception.getMessage());
        return new ResponseEntity(new ExceptionDto(exception.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    // HttpMessageNotReadableException  => json 파싱 오류
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableExceptionEx(HttpMessageNotReadableException exception) {
        log.error("Json 파싱 과정에서 예외 발생! {}", exception.getMessage());
        return new ResponseEntity(new ExceptionDto("json 파싱 과정에서 예외가 발생했습니다."), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity handleNullEx(Exception exception) {
//        log.error("NullPointerException 발생! {}", exception.getMessage());
//        return new ResponseEntity<>(new ExceptionDto("null 값을 참조하여 예외가 발생했습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleIoEx(IOException exception) {
        log.error("IOException 발생 ! {}", exception.getMessage());
        return new ResponseEntity<>(new ExceptionDto("IOException 발생했습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIoEx(IllegalArgumentException exception) {
        log.error("IllegalArgumentException 발생 ! {}", exception.getMessage());
        return new ResponseEntity<>(new ExceptionDto("IllegalArgumentException 발생했습니다."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity handleIoEx(SignatureException exception) {
        log.error("SignatureException 발생 ! {}", exception.getMessage());
        return new ResponseEntity<>(new ExceptionDto(
                "Signature Exception이 발생했습니다. 유효한 인증 정보인지 확인하세요."
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity handleIoEx(IllegalStateException exception) {
        log.error("IllegalState Exception 발생 ! {}", exception.getMessage());
        return new ResponseEntity<>(new ExceptionDto(
                "IllegalState Exception이 발생했습니다. 적절한 호출인지 확인하세요"
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleMemberEx(Exception exception) {
        exception.printStackTrace();
        return new ResponseEntity(HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class ExceptionDto {
        private String errorMessage;
    }
}
