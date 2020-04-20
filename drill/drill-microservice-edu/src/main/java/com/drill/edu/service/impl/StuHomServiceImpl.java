package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.drill.edu.entity.StuHom;
import com.drill.edu.mapper.StuHomMapper;
import com.drill.edu.service.StuHomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.nashorn.internal.runtime.arrays.IntElements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Service
public class StuHomServiceImpl extends ServiceImpl<StuHomMapper, StuHom> implements StuHomService {

    @Override
    public List<Integer> getHomeWorkByUid(Integer uid) {
        QueryWrapper<StuHom> qw = new QueryWrapper<>();
        qw.eq("user_id",uid);
        List<StuHom> stuHoms = baseMapper.selectList(qw);
        ArrayList<Integer> hids = new ArrayList<>();
        stuHoms.forEach(i->{
            hids.add(i.getHomId());
        });
        return hids;

    }



}
