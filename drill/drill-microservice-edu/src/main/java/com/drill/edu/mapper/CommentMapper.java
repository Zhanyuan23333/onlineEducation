package com.drill.edu.mapper;

import com.drill.edu.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
