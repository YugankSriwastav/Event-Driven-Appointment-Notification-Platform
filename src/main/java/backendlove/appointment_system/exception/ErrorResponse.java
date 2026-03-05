package backendlove.appointment_system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    int status;
    String error;
    String massage;
    LocalDateTime dateTime;

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.massage = message;
        dateTime = LocalDateTime.now();
    }
}
