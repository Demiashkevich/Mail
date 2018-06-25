package com.dzemiashkevich.mail;

public enum StatusRestDto {

    OPEN("OPEN"), IN_PROGRESS("IN_PROGRESS"), REJECT("REJECT"), RESOLVED("RESOLVER");

    private String value;

    StatusRestDto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
