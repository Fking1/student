package club.fangqcloud.impl;

import club.fangqcloud.mapper.ClassMapper;
import club.fangqcloud.mapper.StudentMapper;
import club.fangqcloud.pojo.Classes;
import club.fangqcloud.pojo.Student;
import club.fangqcloud.service.ClassService;
import club.fangqcloud.service.StudentService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Page<Student> selectByCondition(Student student){
        return studentMapper.selectByCondition(student);
    }

    @Override
    public Boolean update(Student student) {
        if(studentMapper.update(student)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Student selectByPrimary(String studentId) {
        return studentMapper.selectByPrimary(studentId);
    }


    @Override
    public Boolean delete(String studentId) {
        if(studentMapper.delete(studentId)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean insert(Student student) {
        if(studentMapper.insert(student)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean add(Map student) {
        if(studentMapper.add(student)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Map> selectScore(String studentId, String courseName) {
        return studentMapper.selectScore(studentId,courseName);
    }
}
