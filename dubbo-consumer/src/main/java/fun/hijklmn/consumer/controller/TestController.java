package fun.hijklmn.consumer.controller;

import fun.hijklmn.bo.DataBo;
import fun.hijklmn.consumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestService testService2;

    @RequestMapping("/get/{content}")
    @ResponseBody
    public DataBo get(@PathVariable String content) {

        return testService2.get(content);

    }

}
