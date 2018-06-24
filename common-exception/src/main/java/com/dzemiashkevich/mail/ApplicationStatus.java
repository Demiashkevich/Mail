package com.dzemiashkevich.mail;

public enum ApplicationStatus {

    ENTITY_NOT_FOUND("LF-1", "The requested %s resource was not found by current id %s"),
    VALIDATION_FAILED("LF-2", "Validation of the request has failed");

    private String levelFail;
    private String message;

    ApplicationStatus(String levelFail, String message) {
        this.levelFail = levelFail;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getLevelFail() {
        return levelFail;
    }
    
}
