package backendlove.appointment_system.contoller;


import backendlove.appointment_system.dtoEntity.AccountDto;
import backendlove.appointment_system.service.AccountService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicApis {

    final AccountService costumerService;

    public PublicApis(AccountService costumerService) {
        this.costumerService = costumerService;
    }

    // signup consumer
    @Transactional
    @PostMapping("/consumer-signup")
    public String signup(@RequestBody AccountDto accountDto){
        costumerService.signupUser(accountDto);
         return "welcome\t" + accountDto.getUserName() +
                 " thank you for give us opportunity";
    }


}
