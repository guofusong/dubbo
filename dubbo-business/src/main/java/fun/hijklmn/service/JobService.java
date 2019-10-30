package fun.hijklmn.service;

import fun.hijklmn.bo.JobBo;

import java.util.List;

public interface JobService {

    Integer addJob(JobBo jobBo);

    Integer addJobList(List<JobBo> jobBo);

}
