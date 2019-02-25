package club.fangqcloud.mapper;

import club.fangqcloud.pojo.User;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    int insert(User user);

    List<User> selectByCondition(User user);

    List<Map> selectTeacherInfo(String userId);

    List<Map> selectStudentInfo(String userId);
}
