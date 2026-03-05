package backendlove.appointment_system.repositiory.criteria;


import backendlove.appointment_system.entity.AccountHolder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientCriteria {

    final MongoTemplate mongoTemplate;

    public PatientCriteria(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<AccountHolder> searchByNumberAndGmail(Long phoNo, String gmail){
        Query query  = new Query(
                Criteria.where("phoNo").is(phoNo)
                        .and("gmail").is(gmail)
        );
            return Optional.ofNullable(
                    mongoTemplate.findOne(
                            query, AccountHolder.class
                    )
            );
    }

}
