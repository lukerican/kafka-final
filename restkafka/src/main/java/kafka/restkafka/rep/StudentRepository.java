package kafka.restkafka.rep;

import kafka.restkafka.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <Student,String> {
}

