package backendlove.appointment_system.dtoEntity;

import lombok.Data;

@Data
public class AccountDto {
    private String userId;
    private String userName;
    private String password;
    private Long phNo;
    private String gmail;
}
