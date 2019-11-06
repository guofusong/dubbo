package fun.hijklmn.bo;

import java.io.Serializable;
import java.util.Date;

public class UserBo implements Serializable {


    private String userId;


    private String userName;


    private Long gender;


    private Integer age;


    private String county;


    private String city;


    private String country;


    private Date createTime;


    private Date updateTime;


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public Long getGender() {
        return gender;
    }


    public void setGender(Long gender) {
        this.gender = gender;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getCounty() {
        return county;
    }


    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
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
