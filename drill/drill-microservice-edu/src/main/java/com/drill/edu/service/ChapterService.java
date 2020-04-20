package com.drill.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.drill.edu.entity.Material;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface ChapterService extends IService<Chapter> {

    public void findALLChapterByCourse(int id, Page<Chapter> pageparam);

}
