package backendlove.appointment_system.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GmailServices {
    @Autowired
    private JavaMailSender javaMailSender;

    // Account Creating Massage
    public void sendMail(String to, String subject, String body){
        try{
            SimpleMailMessage massage = new SimpleMailMessage();
            massage.setTo(to);
            massage.setSubject(subject);
            massage.setText(body);
            javaMailSender.send(massage);
        }catch(Exception exception){
            log.error("While Sending the massages");
            exception.getMessage();
        }
    }

    // Otp Massages

     public void otpMail(String to, String subject, String massage){

     }
}
