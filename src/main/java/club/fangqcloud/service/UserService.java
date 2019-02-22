package club.fangqcloud.service;

import club.fangqcloud.pojo.User;

import java.util.List;

public interface UserService {

    Boolean insert(User user);

    List<User> selectByCondition(User user);
}
