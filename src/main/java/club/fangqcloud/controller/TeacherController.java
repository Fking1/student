package club.fangqcloud.controller;

import club.fangqcloud.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getGrade.do")
    @ResponseBody
    public List<Map> getGrade(String teacherId){
        return teacherService.selectGrade(teacherId);
    }
}
