
package com.stackroute.Muzix.exception;

import com.stackroute.Muzix.Response.ResponseForError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class TrackGlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TrackAlreadyExsistException.class})
    public ResponseEntity<ResponseForError> globalTrackAlreadyExistsException(TrackAlreadyExsistException ex) throws Exception{
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessageInformation(ex.getMessage());
        return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TrackNotFoundException.class})
    public ResponseEntity<ResponseForError> globalTrackNotFoundException(TrackNotFoundException ex) throws Exception{
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorID(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessageInformation(ex.getMessage());
        return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
    }
}