package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.StuCour;
import com.drill.edu.mapper.StuCourMapper;
import com.drill.edu.service.StuCourService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drill.edu.vo.ScoreQuery;
import com.mysql.fabric.xmlrpc.base.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Service
public class StuCourServiceImpl extends ServiceImpl<StuCourMapper, StuCour> implements StuCourService {

    @Override
    public void findAllScoreByCourseId(Page<StuCour> pageparam, Integer id) {
        QueryWrapper<StuCour> qw = new QueryWrapper<>();
        qw.eq("cour_id",id);
        baseMapper.selectPage(pageparam,qw);
    }

    @Override
    public void findScoreByParam(Page<StuCour> pageparam, ScoreQuery sq, List<Integer> ids) {
        Integer courseId = sq.getCourId();
        Integer lowScore = sq.getLowScore();
        Integer highScore = sq.getHighScore();
        QueryWrapper<StuCour> qw = new QueryWrapper<>();
        if(courseId!=null){
            qw.eq("cour_id",courseId);
        }
        if(lowScore!=null){
            qw.ge("u_c_score",lowScore);
        }
        if(highScore!=null){
            qw.le("u_c_score",highScore);
        }
        if(ids!=null){
            if(ids.size()==0){
                pageparam.setRecords(null).setTotal(0);
                return;
            }else{
                for(Integer id : ids){
                    qw.eq("user_id",id).or();
                }
            }
        }

        baseMapper.selectPage(pageparam, qw);



    }

    @Override
    public void findCourseIdByStuId(Integer id, Page<StuCour> pageparam) {
        QueryWrapper<StuCour> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        baseMapper.selectPage(pageparam,qw);
    }
}
