package com.dzemiashkevich.mail.handler;

import com.dzemiashkevich.mail.ApplicationException;
import com.dzemiashkevich.mail.ApplicationExceptionResponse;
import com.dzemiashkevich.mail.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private CommonHttpStatusMapper statusMapper;

    @ExceptionHandler(value = ApplicationException.class)
    protected ResponseEntity handleConflict(ApplicationException exception, WebRequest request) {
        ApplicationExceptionResponse status = new ApplicationExceptionResponse(exception);
        HttpStatus httpStatus = statusMapper.toHttpStatus(exception.getApplicationStatus());
        return handleExceptionInternal(exception, status, null, httpStatus, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        ApplicationExceptionResponse status = new ApplicationExceptionResponse(exception);
        httpStatus = statusMapper.toHttpStatus(ApplicationStatus.VALIDATION_FAILED);
        return handleExceptionInternal(exception, status, headers, httpStatus, request);
    }

}
