package kafka.restkafka.kaffka;

import org.apache.catalina.User;
import kafka.restkafka.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, Student> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(Student data){
        LOGGER.info(String.format("message sent %s",data.toString()));
        Message<Student> message = MessageBuilder
                .withPayload(data).
                setHeader(KafkaHeaders.TOPIC,"t3")
                .build();
        kafkaTemplate.send(message);
    }
}
