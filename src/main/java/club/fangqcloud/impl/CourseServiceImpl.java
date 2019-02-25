package club.fangqcloud.impl;

import club.fangqcloud.mapper.CourseMapper;
import club.fangqcloud.pojo.Course;
import club.fangqcloud.service.CourseService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public Page<Course> selectByCondition(String courseName){
        return courseMapper.selectByCondition(courseName);
    }

    @Override
    public Boolean update(Course course) {
        if(courseMapper.update(course)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Course selectByPrimary(String courseId) {
        return courseMapper.selectByPrimary(courseId);
    }


    @Override
    public Boolean delete(String courseId) {
        if(courseMapper.delete(courseId)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean insert(Course course) {
        if(courseMapper.insert(course)>0){
            return true;
        }else{
            return false;
        }
    }
}
