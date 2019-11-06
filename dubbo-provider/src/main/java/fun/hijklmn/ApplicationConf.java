package fun.hijklmn;

import fun.hijklmn.kafka.client.provider.HijklmnKafkaProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConf {

    @Bean(initMethod = "init")
    public HijklmnKafkaProvider hijklmnKafkaProvider() {
        return new HijklmnKafkaProvider();
    }

}
