package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Classes;
import club.fangqcloud.pojo.Score;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {

    int update(Score score);
}
