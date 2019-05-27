package com.stackroute.Muzix.exception;

public class TrackAlreadyExsistException extends Exception {
    private String message;

    public TrackAlreadyExsistException(){}

    public TrackAlreadyExsistException(String message)
    {
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
