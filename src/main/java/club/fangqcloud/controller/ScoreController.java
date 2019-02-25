package club.fangqcloud.controller;

import club.fangqcloud.pojo.Score;
import club.fangqcloud.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Action;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/add.do")
    @ResponseBody
    public Boolean add(Score score){
        return scoreService.update(score);
    }
}
