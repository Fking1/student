package club.fangqcloud.service;

import club.fangqcloud.pojo.User;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface UserService {

    Boolean insert(User user);

    List<User> selectByCondition(User user);

    List<Map> selectTeacherInfo(String userId);

    List<Map> selectStudentInfo(String userId);
}
