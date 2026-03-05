package backendlove.appointment_system.service;

import backendlove.appointment_system.dtoEntity.AccountDto;
import backendlove.appointment_system.dtoMapper.AccountMapper;
import backendlove.appointment_system.entity.AccountHolder;
import backendlove.appointment_system.exception.EntryAlreadyCreated;
import backendlove.appointment_system.repositiory.core.PatientRepository;
import backendlove.appointment_system.repositiory.criteria.PatientCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Slf4j
@Service
public class AccountService {
    final PatientRepository costumerRepository;
    final AccountMapper accountMapper;
    final PatientCriteria patientCriteria;
    final GmailServices gmailServices;

    public AccountService(PatientRepository costumerRepository, AccountMapper accountMapper, PatientCriteria patientCriteria,
                          GmailServices gmailServices) {
        this.costumerRepository = costumerRepository;
        this.accountMapper = accountMapper;
        this.patientCriteria = patientCriteria;

        this.gmailServices = gmailServices;
    }


    @Transactional
    public ResponseEntity<String> signupUser(@RequestBody AccountDto accountDto) {

        System.out.println("ph no " + accountDto.getPhNo());

        AccountHolder patientDetails = accountMapper.FromDto(accountDto);

        String userName = patientDetails.getUserName();
        Long phoneNo = patientDetails.getPhoNo();
        String gmail = patientDetails.getGmail();
        log.info("phone No = {}", phoneNo);
        log.info("gmail  = {}", gmail);
        log.info("result = {}",
                patientCriteria.searchByNumberAndGmail(phoneNo, gmail).isPresent());


        // Agar number + gmail pehle se exist karta hai
        if (patientCriteria.searchByNumberAndGmail(phoneNo, gmail).isPresent()) {

            log.info("Exception class executed because phone and username are already exits");
            throw new EntryAlreadyCreated(
                    String.format(
                            "User %s with phone number %s is already in use",
                            userName, phoneNo
                    )
            );
        }

        // Save user

        log.info("user is going to be save");

        costumerRepository.save(patientDetails);

        gmailServices.sendMail(
                gmail,
                "Your Account is Created",
                "Thanks " + userName + ", your account has been created successfully."
        );

        log.info("Account is Created");

        return ResponseEntity.ok("Signup successful");
    }


    // findByUserNane

    public Optional<AccountHolder> findByUserName(String userName){
        return costumerRepository.findByUserName(userName);
    }
}
