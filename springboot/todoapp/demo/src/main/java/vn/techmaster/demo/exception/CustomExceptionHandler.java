package vn.techmaster.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.techmaster.demo.response.ErrorResponse;


@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BadRequestEx.class)
    public ResponseEntity<?> handleResourceNotFoundException(BadRequestEx ex){
       return new ResponseEntity<>(
               new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()),
               HttpStatus.BAD_REQUEST
       );
    }

    @ExceptionHandler(ResourceNotFoundEx.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundEx ex){
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class) //Những exception còn lại
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<>(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
