package com.dzemiashkevich.mail.handler;

import com.dzemiashkevich.mail.ApplicationStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

@Component
public class CommonHttpStatusMapper {

    private Map<ApplicationStatus, HttpStatus> exceptionMap = new EnumMap<>(ApplicationStatus.class);

    @PostConstruct
    public void init() {
        exceptionMap.put(ApplicationStatus.ENTITY_NOT_FOUND, HttpStatus.NOT_FOUND);
        exceptionMap.put(ApplicationStatus.VALIDATION_FAILED, HttpStatus.BAD_REQUEST);
    }

    public HttpStatus toHttpStatus(ApplicationStatus applicationErrorStatus) {
        return exceptionMap.getOrDefault(applicationErrorStatus, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
