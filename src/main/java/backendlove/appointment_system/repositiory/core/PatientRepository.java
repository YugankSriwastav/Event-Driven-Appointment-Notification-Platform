package backendlove.appointment_system.repositiory.core;
import backendlove.appointment_system.entity.AccountHolder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<AccountHolder, String>
{
// findByUserName
    Optional<AccountHolder> findByUserName(String userName);

}
