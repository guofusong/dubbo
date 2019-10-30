package fun.hijklmn.service.impl;

import fun.hijklmn.bo.JobBo;
import fun.hijklmn.mapper.JobMapper;
import fun.hijklmn.pojo.Job;
import fun.hijklmn.service.CommonService;
import fun.hijklmn.service.JobService;
import fun.hijklmn.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobServiceImpl extends CommonService implements JobService {

    @Resource
    private JobMapper jobMapper;

    public Integer addJob(JobBo jobBo) {

        Job job = new Job();

        try {

            BeanUtil.copyProperties(job, jobBo);

            return jobMapper.insertSelective(job);

        } catch(Exception e) {
            logger.error("----->添加工作出错！", e);
        }

        return null;

    }

    public Integer addJobList(List<JobBo> jobBo) {
        return null;
    }

}
