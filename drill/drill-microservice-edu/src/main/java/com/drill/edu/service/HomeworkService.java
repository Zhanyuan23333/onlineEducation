package com.drill.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Homework;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface HomeworkService extends IService<Homework> {

    public void findByCourseId(Integer id, Page<Homework> pageparam);

    List<Homework> getByIds(List<Integer> hids);
}
