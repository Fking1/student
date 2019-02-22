package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Classes;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {

    Page<Classes> selectByCondition(@Param(value = "className") String className);

    Classes selectByPrimary(String classId);

    int update(Classes classes);

    int delete(String classId);

    int insert(Classes classes);
}
