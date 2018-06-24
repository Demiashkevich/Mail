package com.dzemiashkevich.mail;

public class ApplicationException extends RuntimeException {

    private final ApplicationStatus applicationStatus;

    public ApplicationException(ApplicationStatus status, Object... parameters) {
        super(String.format(status.getMessage(), parameters));
        this.applicationStatus = status;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

}
