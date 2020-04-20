package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.edu.entity.Material;
import com.drill.edu.mapper.MaterialMapper;
import com.drill.edu.service.MaterialService;
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
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Override
    public void findMaterialbyChapter(Integer id, Page<Material> pageparam) {
        QueryWrapper<Material> qw = new QueryWrapper<>();
        qw.eq("mat_cha_id",id);
        baseMapper.selectPage(pageparam,qw);
    }

    @Override
    public List<Material> findByCourseId(Integer cid) {
        QueryWrapper<Material> qw = new QueryWrapper<>();
        qw.eq("mat_cha_id", cid);
        List<Material> materials = baseMapper.selectList(qw);
        return materials;
    }
}
