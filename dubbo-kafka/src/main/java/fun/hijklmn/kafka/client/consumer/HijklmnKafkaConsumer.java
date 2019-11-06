package fun.hijklmn.kafka.client.consumer;

import fun.hijklmn.kafka.constant.KafkaConstant;
import fun.hijklmn.kafka.service.HijklmnConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

public class HijklmnKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(HijklmnKafkaConsumer.class);

    private static boolean isService = true;

    private HijklmnConsumerService hijklmnConsumerService;

    private Properties properties = new Properties();

    public HijklmnKafkaConsumer() {}

    public HijklmnKafkaConsumer(HijklmnConsumerService hijklmnConsumerService) {
        this.hijklmnConsumerService = hijklmnConsumerService;
    }

    public HijklmnKafkaConsumer(Properties properties) {
        this.properties.putAll(properties);
    }

    public HijklmnKafkaConsumer addProperties(Object key, Object value) {
        properties.put(key, value);
        return this;
    }

    public HijklmnKafkaConsumer addMap(Map<Object, Object> map) {
        properties.putAll(map);
        return this;
    }

    public void init() {

        if (!isService) {
            logger.info("---------> Kafka消费者已经启动。");
            return;
        }

        if (properties.isEmpty()) {

            properties.put("bootstrap.servers", KafkaConstant.DEFAULT_BOOTSTRAP_SERVERS);
            properties.put("group.id", KafkaConstant.DEFAULT_GROUP_ID);
            properties.put("enable.auto.commit", KafkaConstant.ENABLE_AUTO_COMMIT);
            properties.put("auto.commit.interval.ms", KafkaConstant.AUTO_COMMIT_INTERVAL_MS);
            properties.put("auto.offset.reset", KafkaConstant.AUTO_OFFSET_RESET);
            properties.put("session.timeout.ms", KafkaConstant.SESSION_TIMEOUT_MS);
            properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        }

        logger.info("---------> Kafka消费者启动成功。");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(KafkaConstant.SUBSCRIBELIST);

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                hijklmnConsumerService.consumer(record);
            }
        }

    }

}
