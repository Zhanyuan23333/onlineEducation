package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Homework;
import com.drill.edu.mapper.HomeworkMapper;
import com.drill.edu.service.HomeworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class HomeworkServiceImpl extends ServiceImpl<HomeworkMapper, Homework> implements HomeworkService {

    @Override
    public void findByCourseId(Integer id, Page<Homework> pageparam) {
        QueryWrapper<Homework> qw = new QueryWrapper<>();
        qw.eq("hom_cou_id",id);
        baseMapper.selectPage(pageparam,qw);
    }

    @Override
    public List<Homework> getByIds(List<Integer> hids) {
        return baseMapper.selectBatchIds(hids);
    }
}
