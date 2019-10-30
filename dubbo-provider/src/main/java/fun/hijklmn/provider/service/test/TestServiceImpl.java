package fun.hijklmn.provider.service.test;

import com.alibaba.dubbo.config.annotation.Service;
import fun.hijklmn.api.TestService;
import fun.hijklmn.bo.DataBo;
import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;
import fun.hijklmn.constant.KafkaConstant;
import fun.hijklmn.kafka.client.provider.HijklmnKafkaProvider;
import fun.hijklmn.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service(interfaceClass = TestService.class)
@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private HijklmnKafkaProvider hijklmnKafkaProvider;

    public DataBo get(String content) {

        DataBo dataBo = new DataBo();
        dataBo.setCode(200);
        dataBo.setMessage("get success");
        dataBo.setObj("-----> service 2 : " + UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());

        return dataBo;

    }

    public DataBo put(String content) {

        DataBo dataBo = new DataBo();
        dataBo.setCode(200);
        dataBo.setMessage("put success");
        dataBo.setObj(content);

        return dataBo;

    }

    public DataBo delete(String content) {

        DataBo dataBo = new DataBo();
        dataBo.setCode(200);
        dataBo.setMessage("delete success");
        dataBo.setObj(content);

        return dataBo;

    }

    public String put(UserBo userBo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "userBo");
        map.put("value", JSONUtil.toJson(userBo));
        hijklmnKafkaProvider.send(KafkaConstant.TOPIC, JSONUtil.toJson(map));
        return null;
    }

    public String put(JobBo jobBo) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "jobBo");
        map.put("value", JSONUtil.toJson(jobBo));
        hijklmnKafkaProvider.send(KafkaConstant.TOPIC, JSONUtil.toJson(map));
        return null;
    }

    public String putList(List<UserBo> userBoList) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "userBoList");
        map.put("value", JSONUtil.toJson(userBoList));
        hijklmnKafkaProvider.send(KafkaConstant.TOPIC, JSONUtil.toJson(map));
        return null;
    }

    public String putJob(List<JobBo> jobBoList) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "jobBoList");
        map.put("value", JSONUtil.toJson(jobBoList));
        hijklmnKafkaProvider.send(KafkaConstant.TOPIC, JSONUtil.toJson(map));
        return null;
    }

}
