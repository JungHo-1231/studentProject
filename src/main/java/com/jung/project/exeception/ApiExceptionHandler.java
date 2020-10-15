package com.jung.project.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    // 에러를 클라이언트로 보낼 때 메세지를 커스터 마이징 할 수 있다.

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_GATEWAY,
                ZonedDateTime.now(ZoneId.of("Z"))

        );
        // 2. Return response entity

        return new ResponseEntity<>(apiException, badRequest);
    }
}
