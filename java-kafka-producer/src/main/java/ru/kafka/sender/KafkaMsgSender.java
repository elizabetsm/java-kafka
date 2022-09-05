package ru.kafka.sender;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Slf4j
public class KafkaMsgSender {

    final KafkaTemplate<String, String> template;

    @Autowired
    public KafkaMsgSender(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendKafkaMsg(String msg){
        ListenableFuture<SendResult<String, String>> future = template.send("topic1", msg);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=["
                        + msg + "] due to : " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + msg +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
