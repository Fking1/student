package club.fangqcloud.impl;

import club.fangqcloud.mapper.UserMapper;
import club.fangqcloud.pojo.User;
import club.fangqcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean insert(User user) {
        if(userMapper.insert(user)>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public List<User> selectByCondition(User user) {
        return userMapper.selectByCondition(user);
    }


    @Override
    public List<Map> selectTeacherInfo(String userId) {
        return userMapper.selectTeacherInfo(userId);
    }

    @Override
    public List<Map> selectStudentInfo(String userId) {
        return userMapper.selectStudentInfo(userId);
    }
}
