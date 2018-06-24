package com.dzemiashkevich.mail;

import org.apache.commons.lang3.StringUtils;

public class ApplicationExceptionResponse {

    private String errorMessage;
    private String causedMessage;

    public ApplicationExceptionResponse() {
    }

    public ApplicationExceptionResponse(Exception ex) {
        this.errorMessage = ex.getMessage();
        this.causedMessage = extractCausedMessage(ex);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCausedMessage() {
        return causedMessage;
    }

    public void setCausedMessage(String causedMessage) {
        this.causedMessage = causedMessage;
    }

    private String extractCausedMessage(Exception exception) {
        if (exception.getCause() != null) {
            return exception.getCause().getMessage() == null ? StringUtils.EMPTY : exception.getCause().getMessage();
        }

        return StringUtils.EMPTY;
    }

}
