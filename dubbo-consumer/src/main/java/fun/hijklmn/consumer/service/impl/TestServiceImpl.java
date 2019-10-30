package fun.hijklmn.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import fun.hijklmn.bo.DataBo;
import fun.hijklmn.consumer.service.TestService;
import org.springframework.stereotype.Service;

@Service("testService2")
public class TestServiceImpl implements TestService {

    @Reference(url = "dubbo://localhost:20888")
    private fun.hijklmn.api.TestService testService;

    public DataBo get(String content) {
        return testService.get(content);
    }

}
