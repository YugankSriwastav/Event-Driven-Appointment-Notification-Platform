package backendlove.appointment_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginEntry {
    @NonNull
    private String userName;
    @NonNull
    private String password;
}
