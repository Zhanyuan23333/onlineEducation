package com.drill.edu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.drill.edu.entity.StuCour;
import com.drill.edu.vo.CourseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface CourseService extends IService<Course> {

    public void findCourseByParam(CourseQuery cq, Page<Course> pageparam);

    List<Course> getByIds(ArrayList<Integer> courseIds);
}
