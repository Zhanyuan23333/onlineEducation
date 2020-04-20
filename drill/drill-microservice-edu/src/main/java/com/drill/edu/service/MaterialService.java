package com.drill.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Material;
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
public interface MaterialService extends IService<Material> {

    public void findMaterialbyChapter(Integer id, Page<Material> pageparam);

    List<Material> findByCourseId(Integer cid);
}
