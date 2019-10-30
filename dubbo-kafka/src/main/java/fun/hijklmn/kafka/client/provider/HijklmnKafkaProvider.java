package fun.hijklmn.kafka.client.provider;

import fun.hijklmn.kafka.constant.KafkaConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Map;
import java.util.Properties;

public class HijklmnKafkaProvider {

    private Properties properties = new Properties();

    public HijklmnKafkaProvider(){

    }

    public HijklmnKafkaProvider(Properties properties) {
        this.properties.putAll(properties);
    }

    public HijklmnKafkaProvider addProperties(Object key, Object value) {
        this.properties.put(key, value);
        return this;
    }

    public HijklmnKafkaProvider addProperties(Map<Object, Object> map) {
        this.properties.putAll(map);
        return this;
    }

    public void send(String topic, String content) {

        if (StringUtils.isBlank(topic)) {
            return;
        }

        if (properties.isEmpty()) {
            properties.put("bootstrap.servers", KafkaConstant.DEFAULT_BOOTSTRAP_SERVERS);
            properties.put("acks",KafkaConstant.ACKS);
            properties.put("retries", KafkaConstant.RETRIES);
            properties.put("batch.size", KafkaConstant.BATCH_SIZE);
            properties.put("linger.ms", KafkaConstant.LINGER_MS);
            properties.put("buffer.memory", KafkaConstant.BUFFER_MEMORY);
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        }

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord producerRecord = new ProducerRecord(topic, content);

        producer.send(producerRecord);

    }

}
