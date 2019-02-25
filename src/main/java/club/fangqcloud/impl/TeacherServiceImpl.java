package club.fangqcloud.impl;

import club.fangqcloud.mapper.TeacherMapper;
import club.fangqcloud.pojo.Teacher;
import club.fangqcloud.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Boolean insert(Map teacher) {
        if(teacherMapper.insert(teacher)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Map> selectGrade(String teacherId) {
        return teacherMapper.selectGrade(teacherId);
    }
}
