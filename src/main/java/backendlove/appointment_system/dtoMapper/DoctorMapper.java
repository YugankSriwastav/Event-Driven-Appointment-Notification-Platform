package backendlove.appointment_system.dtoMapper;

import backendlove.appointment_system.dtoEntity.AccountDto;
import backendlove.appointment_system.entity.AccountHolder;
import org.springframework.stereotype.Component;
@Component
public class DoctorMapper {
    // DTO Tp Entity

    public AccountHolder FromDto(AccountDto patientDto){
        return new AccountHolder(
                patientDto.getUserId(),
                patientDto.getUserName(),
               patientDto.getPassword()

        );
    }

}
