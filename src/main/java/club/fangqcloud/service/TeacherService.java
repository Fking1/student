package club.fangqcloud.service;

import club.fangqcloud.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    Boolean insert(Map teacher);

    List<Map> selectGrade(String teacherId);
}
