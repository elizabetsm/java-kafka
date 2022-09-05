package ru.kafka;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
import ru.kafka.sender.KafkaMsgSender;

@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Main {

    final KafkaMsgSender sender;

    public Main(KafkaMsgSender sender) {
        this.sender = sender;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Scheduled(cron = "0/1 * * * *")
    public void send(){
        sender.sendKafkaMsg("hello!!!");
    }
}
