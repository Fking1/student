package club.fangqcloud.service;

import club.fangqcloud.pojo.Student;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Page<Student> selectByCondition(Student student);

    Student selectByPrimary(String studentId);

    Boolean update(Student student);

    Boolean delete(String studentId);

    Boolean insert(Student student);

    Boolean add(Map student);

    List<Map> selectScore(String studentId, String courseName);
}
