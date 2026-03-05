package backendlove.appointment_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntryAlreadyCreated.class)
    public ResponseEntity<ErrorResponse> handleEntryAlreadyCreated(
            EntryAlreadyCreated entryAlreadyCreated
    ){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                entryAlreadyCreated.getMessage()

        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


}
