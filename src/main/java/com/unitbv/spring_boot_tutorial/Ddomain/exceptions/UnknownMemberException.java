package com.unitbv.spring_boot_tutorial.Ddomain.exceptions;

public class UnknownMemberException extends RuntimeException {
    public UnknownMemberException(String message) {
        super(message);
    }
}
