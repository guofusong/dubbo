package fun.hijklmn.consumer.service;

import fun.hijklmn.bo.DataBo;
import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;

public interface TestService {

    DataBo get(String content);

    String putUser(UserBo userBo);

    String putJob(JobBo jobBo);

}
