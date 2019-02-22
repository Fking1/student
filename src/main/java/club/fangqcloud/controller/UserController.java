package club.fangqcloud.controller;

import club.fangqcloud.pojo.User;
import club.fangqcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register.do")
    @ResponseBody
    public Boolean register(User userInfo){
        List<User> userList = userService.selectByCondition(userInfo);
        System.out.println(userList);
        if(userList != null){
            return false;
        }else{
            userInfo.setUserId(String.valueOf(System.currentTimeMillis()));
            return userService.insert(userInfo);
        }
    }


    @RequestMapping("/login.do")
    @ResponseBody
    public Boolean login(User userInfo){
        return null;
    }


}
