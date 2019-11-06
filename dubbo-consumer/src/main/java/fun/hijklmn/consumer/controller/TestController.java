package fun.hijklmn.consumer.controller;

import fun.hijklmn.bo.DataBo;
import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;
import fun.hijklmn.consumer.service.TestService;
import fun.hijklmn.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Controller
public class TestController {

    private String[] cities = new String[]{"北京", "上海", "广州", "深圳", "天津", "重庆", "成都", "武汉", "南京", "杭州"};

    @Autowired
    private TestService testService2;

    @RequestMapping("/get/{content}")
    @ResponseBody
    public DataBo get(@PathVariable String content) {

        return testService2.get(content);

    }

    @RequestMapping("/put/job")
    @ResponseBody
    public String putJob() {

        JobBo jobBo = new JobBo();

        jobBo.setCreateTime(new Date());

        jobBo.setJobDesc("job desc");

        jobBo.setJobId(UUIDUtil.uuid());

        jobBo.setJobName(UUIDUtil.nonStr(32));

        return testService2.putJob(jobBo);

    }

    @RequestMapping("/put/user")
    @ResponseBody
    public String putUser() {

        UserBo userBo = new UserBo();

        userBo.setAge(new Random().nextInt(23));

        userBo.setCity(cities[new Random().nextInt(cities.length)]);

        userBo.setCountry("中国");

        userBo.setCounty("区县");

        userBo.setCreateTime(new Date());

        userBo.setGender((long) new Random().nextInt(2));

        userBo.setUserId(UUIDUtil.uuid());

        userBo.setUserName(UUIDUtil.nonStr(32));

        return testService2.putUser(userBo);

    }

}
