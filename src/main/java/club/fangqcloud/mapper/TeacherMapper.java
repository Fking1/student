package club.fangqcloud.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {

    int insert(Map teacher);

    List<Map> selectGrade(@Param(value = "teacherId") String teacherId);

}
