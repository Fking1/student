package club.fangqcloud.service;

import club.fangqcloud.pojo.Course;
import com.github.pagehelper.Page;

public interface CourseService {
    Page<Course> selectByCondition(String courseName);

    Course selectByPrimary(String courseId);

    Boolean update(Course course);

    Boolean delete(String classId);

    Boolean insert(Course course);
}
