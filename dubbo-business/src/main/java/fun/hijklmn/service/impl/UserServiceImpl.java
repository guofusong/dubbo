package fun.hijklmn.service.impl;

import fun.hijklmn.bo.UserBo;
import fun.hijklmn.mapper.UserMapper;
import fun.hijklmn.pojo.User;
import fun.hijklmn.service.CommonService;
import fun.hijklmn.service.UserService;
import fun.hijklmn.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends CommonService implements UserService {

    @Resource
    private UserMapper userMapper;

    public Integer addUser(UserBo userBo) {

        User user = new User();

        try {

            BeanUtil.copyProperties(user, userBo);

            return userMapper.insertSelective(user);

        } catch (Exception e) {
            logger.error("-----> 添加用户出错！", e);
        }

        return null;

    }

    public Integer addUser(List<UserBo> userBoList) {
        return null;
    }

}
