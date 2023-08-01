package kafka.restkafka.kaffka;

import kafka.restkafka.rep.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private StudentRepository studentRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "t3", groupId = "myGroup")
    public void consume(String message){
    LOGGER.info(String.format("Message received is %s",message));
    }
}
