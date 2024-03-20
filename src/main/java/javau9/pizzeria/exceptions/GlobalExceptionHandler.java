package javau9.pizzeria.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PizzaNotFoundException.class)
    public ResponseEntity<?> handleSpecificException(PizzaNotFoundException ex, WebRequest request) {        
      
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
       
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
