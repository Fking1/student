package club.fangqcloud.controller;

import club.fangqcloud.pojo.Classes;
import club.fangqcloud.service.ClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;


    @RequestMapping("/getByCondition.do")
    @ResponseBody
    public PageInfo<Classes> getByCondition(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize,String className){
        PageHelper.startPage(pageNum,pageSize);
        System.out.println(className);
        PageInfo<Classes> pageInfo = new PageInfo<>(classService.selectByCondition(className));
        return pageInfo;
    }


    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(Classes pageInfo){
        return classService.update(pageInfo);
    }


    @RequestMapping("/getByPrimary.do")
    @ResponseBody
    public Classes getByPrimary(String classId){
        return classService.selectByPrimary(classId);
    }


    @RequestMapping("/remove.do")
    @ResponseBody
    public Boolean remove(String classId){
        return classService.delete(classId);
    }


    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(Classes pageInfo){
        return classService.insert(pageInfo);
    }
}
