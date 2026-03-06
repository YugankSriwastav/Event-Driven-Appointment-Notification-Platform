package backendlove.appointment_system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class AccountHolder {
    @Id
    private String userId;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private Long phoNo;
    @NonNull
    private String gmail;
    ROLE role;
   public AccountHolder(String userId,
                        String userName,
                        String password)
   {
       this.userId = userId;
       this.userName = userName;
       this.password = password;
   }

    public AccountHolder(String userId, String userName, String password, Long phNo, String gmail) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phoNo = phNo;
        this.gmail = gmail;

    }
}
