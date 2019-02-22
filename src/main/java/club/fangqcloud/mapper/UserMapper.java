package club.fangqcloud.mapper;

import club.fangqcloud.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User user);

    List<User> selectByCondition(User user);
}
