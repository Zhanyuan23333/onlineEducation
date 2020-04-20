package com.drill.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.common.vo.R;
import com.drill.edu.entity.StuCour;
import com.baomidou.mybatisplus.extension.service.IService;
import com.drill.edu.vo.ScoreQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface StuCourService extends IService<StuCour> {
    public void findAllScoreByCourseId(Page<StuCour> pageparam, Integer id);
    public void findScoreByParam(Page<StuCour> pageparam, ScoreQuery sq, List<Integer> ids);

    void findCourseIdByStuId(Integer id, Page<StuCour> pageparam);
}
