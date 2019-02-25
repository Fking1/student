package club.fangqcloud.impl;

import club.fangqcloud.mapper.ClassMapper;
import club.fangqcloud.mapper.ScoreMapper;
import club.fangqcloud.pojo.Classes;
import club.fangqcloud.pojo.Score;
import club.fangqcloud.service.ClassService;
import club.fangqcloud.service.ScoreService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Boolean update(Score score) {
        if(scoreMapper.update(score)>0){
            return true;
        }else{
            return false;
        }
    }
}
