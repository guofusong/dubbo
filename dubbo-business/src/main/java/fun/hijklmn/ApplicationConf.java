package fun.hijklmn;

import fun.hijklmn.conf.MysqlConf;
import fun.hijklmn.kafka.client.consumer.HijklmnKafkaConsumer;
import fun.hijklmn.kafka.service.HijklmnConsumerService;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MysqlConf.class})
@ServletComponentScan
public class ApplicationConf {

    @Bean(initMethod = "init")
    public HijklmnKafkaConsumer hijklmnKafkaConsumer(HijklmnConsumerService hijklmnConsumerService) {
        return new HijklmnKafkaConsumer(hijklmnConsumerService);
    }

}
