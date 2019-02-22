package club.fangqcloud.impl;

import club.fangqcloud.mapper.ClassMapper;
import club.fangqcloud.pojo.Classes;
import club.fangqcloud.service.ClassService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    public Page<Classes> selectByCondition(String className){
        return classMapper.selectByCondition(className);
    }

    @Override
    public Boolean update(Classes classes) {
        if(classMapper.update(classes)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Classes selectByPrimary(String classId) {
        return classMapper.selectByPrimary(classId);
    }


    @Override
    public Boolean delete(String classId) {
        if(classMapper.delete(classId)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean insert(Classes classes) {
        if(classMapper.insert(classes)>0){
            return true;
        }else{
            return false;
        }
    }
}
