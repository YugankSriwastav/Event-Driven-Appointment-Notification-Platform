package backendlove.appointment_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
// well you don't need mention all args no args because both are by default comes with @Data
@Data
public class Doctor {

    @Id
    int doctorId;
    // after create account doctor should be
    // found his id and password on his gmail
    @NonNull
    int docPassword;
    @NonNull
    String doctorName;
    @NonNull
    String specification;
    @NonNull
    String doctorDegree;
    @NonNull
    String docMail;
    LocalDateTime availbility;
    @NonNull
    int yearOfExperience;
    @NonNull
    String role;
}
