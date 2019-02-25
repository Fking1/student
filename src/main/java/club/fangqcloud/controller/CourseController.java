package club.fangqcloud.controller;

import club.fangqcloud.pojo.Course;
import club.fangqcloud.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/getByCondition.do")
    @ResponseBody
    public PageInfo<Course> getByCondition(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize, String courseName){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Course> pageInfo = new PageInfo<>(courseService.selectByCondition(courseName));
        return pageInfo;
    }


    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(Course pageInfo){
        return courseService.update(pageInfo);
    }


    @RequestMapping("/getByPrimary.do")
    @ResponseBody
    public Course getByPrimary(String courseId){
        return courseService.selectByPrimary(courseId);
    }


    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String courseId){
        return courseService.delete(courseId);
    }


    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(Course pageInfo){
        return courseService.insert(pageInfo);
    }
}
