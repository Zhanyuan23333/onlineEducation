package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Course;
import com.drill.edu.entity.StuCour;
import com.drill.edu.entity.User;
import com.drill.edu.mapper.CourseMapper;
import com.drill.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drill.edu.vo.CourseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public void findCourseByParam(CourseQuery cq, Page<Course> pageparam) {
        QueryWrapper<Course> qw = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(cq.getCourName())){
            qw.like("cour_name", cq.getCourName());
        }
        if(cq.getCourGrade()!=0){
            qw.eq("cour_grade", cq.getCourGrade());
        }

        baseMapper.selectPage(pageparam, qw);
    }

    @Override
    public List<Course> getByIds(ArrayList<Integer> courseIds) {
        List<Course> courses = baseMapper.selectBatchIds(courseIds);
        return courses;
    }
}
