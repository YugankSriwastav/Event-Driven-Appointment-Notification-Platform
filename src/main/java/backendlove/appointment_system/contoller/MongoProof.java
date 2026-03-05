package backendlove.appointment_system.contoller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoProof {
    MongoProof(MongoTemplate template) {
        System.out.println("👉 Mongo DB = " + template.getDb().getName());
    }
}
