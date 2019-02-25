package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Course;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {

    Page<Course> selectByCondition(@Param(value = "courseName") String courseName);

    Course selectByPrimary(String courseId);

    int update(Course course);

    int delete(String courseId);

    int insert(Course course);
}
