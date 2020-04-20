package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.drill.edu.entity.Comment;
import com.drill.edu.mapper.CommentMapper;
import com.drill.edu.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<Comment> findByCourseId(Integer cid) {
        QueryWrapper<Comment> qw = new QueryWrapper<>();
        qw.eq("cour_id",cid);
        List<Comment> comments = baseMapper.selectList(qw);
        return comments;
    }
}
