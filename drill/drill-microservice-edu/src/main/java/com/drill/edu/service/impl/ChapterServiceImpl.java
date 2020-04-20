package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Chapter;
import com.drill.edu.entity.Material;
import com.drill.edu.mapper.ChapterMapper;
import com.drill.edu.service.ChapterService;
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
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Override
    public void findALLChapterByCourse(int id, Page<Chapter> pageparam) {
        QueryWrapper<Chapter> qw = new QueryWrapper<>();
        qw.eq("cha_cour_id",id);
        baseMapper.selectPage(pageparam,qw);
    }


}
