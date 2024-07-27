package com.kpit.myworld.candidate.exception;

public class NoSuchCandidateException extends RuntimeException {

    private String message;

    public NoSuchCandidateException(String message) {
        super(message);
        this.message = message;
    }


}
