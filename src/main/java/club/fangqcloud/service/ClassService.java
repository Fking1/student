package club.fangqcloud.service;

import club.fangqcloud.pojo.Classes;
import com.github.pagehelper.Page;

public interface ClassService {
    Page<Classes> selectByCondition(String className);

    Classes selectByPrimary(String classId);

    Boolean update(Classes classes);

    Boolean delete(String classId);

    Boolean insert(Classes classes);
}
