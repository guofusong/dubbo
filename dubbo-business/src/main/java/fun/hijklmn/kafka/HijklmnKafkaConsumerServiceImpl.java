package fun.hijklmn.kafka;

import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;
import fun.hijklmn.kafka.service.HijklmnConsumerService;
import fun.hijklmn.service.JobService;
import fun.hijklmn.service.UserService;
import fun.hijklmn.utils.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HijklmnKafkaConsumerServiceImpl implements HijklmnConsumerService {

    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    public void consumer(ConsumerRecord consumerRecord) {

        String rValue = (String) consumerRecord.value();

        if (StringUtils.isBlank(rValue)) {
            return;
        }

        Map<String, String> map = JSONUtil.toBean(rValue, Map.class);

        if (map == null) {
            return;
        }

        if (!map.containsKey("type") || !map.containsKey("value")) {
            return;
        }

        String key = map.get("type");

        String value = map.get("value");

        if ("userBo".equals(key)) {

            UserBo userBo = JSONUtil.toBean(value, UserBo.class);

            userService.addUser(userBo);

        } else if ("jobBo".equals(key)) {

            JobBo jobBo = JSONUtil.toBean(value, JobBo.class);

            jobService.addJob(jobBo);

        }

    }

}
