package com.drill.edu.service;

import com.drill.edu.entity.Comment;
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
public interface CommentService extends IService<Comment> {

    List<Comment> findByCourseId(Integer cid);
}
