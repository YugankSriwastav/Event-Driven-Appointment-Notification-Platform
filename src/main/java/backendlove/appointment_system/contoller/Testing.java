package backendlove.appointment_system.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/testing")
public class Testing {
    @GetMapping
    public String testing(){
        return "EveryThing running fine";
    }
}
