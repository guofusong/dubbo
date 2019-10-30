package fun.hijklmn.api;

import fun.hijklmn.bo.DataBo;
import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;

import java.util.List;

public interface TestService {

    public DataBo get(String content);

    public DataBo put(String content);

    public DataBo delete(String content);

    public String put(UserBo userBo);

    public String put(JobBo jobBo);

    public String putList(List<UserBo> userBoList);

    public String putJob(List<JobBo> jobBoList);

}
