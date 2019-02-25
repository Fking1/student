package club.fangqcloud.controller;

import club.fangqcloud.pojo.Student;
import club.fangqcloud.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/getByCondition.do")
    @ResponseBody
    public PageInfo<Student> getByCondition(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize, Student student){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(studentService.selectByCondition(student));
        return pageInfo;
    }


    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(Student pageInfo){
        return studentService.update(pageInfo);
    }


    @RequestMapping("/getByPrimary.do")
    @ResponseBody
    public Student getByPrimary(String studentId){
        return studentService.selectByPrimary(studentId);
    }


    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String studentId){
        return studentService.delete(studentId);
    }


    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(Student pageInfo){
        return studentService.insert(pageInfo);
    }


    @RequestMapping("/getScore.do")
    @ResponseBody
    public List<Map> getScore(String studentId, String courseName){
        return studentService.selectScore(studentId, courseName);
    }
}
