package fun.hijklmn.bo;

import java.util.Date;

public class JobBo {


    private String jobId;


    private String jobName;


    private String jobDesc;


    private Date createTime;


    private Date updateTime;


    public String getJobId() {
        return jobId;
    }


    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }


    public String getJobName() {
        return jobName;
    }


    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }


    public String getJobDesc() {
        return jobDesc;
    }


    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc == null ? null : jobDesc.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
