package fun.hijklmn.service;

import fun.hijklmn.bo.JobBo;
import fun.hijklmn.bo.UserBo;

import java.util.List;

public interface UserService {

    public Integer addUser(UserBo userBo);

    public Integer addUser(List<UserBo> userBoList);

}
