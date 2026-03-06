package backendlove.appointment_system.contoller;


import backendlove.appointment_system.dtoEntity.AccountDto;
import backendlove.appointment_system.entity.AccountHolder;
import backendlove.appointment_system.entity.LoginEntry;
import backendlove.appointment_system.filter.JwtUtil;
import backendlove.appointment_system.repositiory.core.PatientRepository;
import backendlove.appointment_system.security.AuthenticationManager;
import backendlove.appointment_system.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicApis {

    private static final Logger log = LoggerFactory.getLogger(PublicApis.class);
    final AccountService costumerService;
    final AuthenticationManager manager;
    final JwtUtil util;
    final PatientRepository patientRepository;

    public PublicApis(AccountService costumerService, AuthenticationManager manager, JwtUtil util, PatientRepository patientRepository) {
        this.costumerService = costumerService;
        this.manager = manager;
        this.util = util;
        this.patientRepository = patientRepository;
    }

    // signup consumer
    @Transactional
    @PostMapping("/consumer-signup")
    public String signup(@RequestBody AccountDto accountDto){
        costumerService.signupUser(accountDto);
         return "welcome\t" + accountDto.getUserName() +
                 " thank you for give us opportunity";
    }

    // login patient

    @Transactional
    @PostMapping("/login")
    // hum yaha user se userName password le rahe hai kyu yah public api hai
    // aur esko access karne ke liye user id aur password nahi dealega to hum esko request body mein lenge
    public ResponseEntity<String> login(@RequestBody LoginEntry loginEntry) {
        // ab hum check karenge user ke through bheji ki body mein password aur username sahi hai ya nahi
        try {


        manager.authentication(
                new UsernamePasswordAuthenticationToken(
                        loginEntry.getUserName(),
                        loginEntry.getPassword()
                )
        );
        // agar authentication complete hota hai to toekn do

            ///  ab hum yah se token banayenge

            AccountHolder accountHolder =  patientRepository.findByUserName(loginEntry.getUserName());


           String token = util.generateToken(loginEntry.getUserName(), accountHolder.getRole(),
                            accountHolder.getGmail(), accountHolder.getPhoNo());
           return new ResponseEntity<>(token, HttpStatus.ACCEPTED);

    } catch (Exception e) {
           log.error("User password are not correct");
            return new ResponseEntity<>("Incorrect userName or password",HttpStatus.CONFLICT);
        }
    }

}
