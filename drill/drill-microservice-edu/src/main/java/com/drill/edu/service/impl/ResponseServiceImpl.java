package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.drill.edu.entity.Response;
import com.drill.edu.mapper.ResponseMapper;
import com.drill.edu.service.ResponseService;
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
public class ResponseServiceImpl extends ServiceImpl<ResponseMapper, Response> implements ResponseService {

    @Override
    public List<Response> findResponseById(Integer commentId) {
        QueryWrapper<Response> qw = new QueryWrapper<>();
        qw.eq("com_id", commentId);
        List<Response> responses = baseMapper.selectList(qw);
        return responses;
    }
}
