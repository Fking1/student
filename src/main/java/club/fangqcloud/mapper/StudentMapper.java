package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Student;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    Page<Student> selectByCondition(Student student);

    Student selectByPrimary(@Param(value = "studentId") String studentId);

    int update(Student student);

    int delete(String studentId);

    int insert(Student student);

    int add(Map student);

    List<Map> selectScore(@Param(value = "studentId") String studentId, @Param(value = "courseName") String courseName);
}
