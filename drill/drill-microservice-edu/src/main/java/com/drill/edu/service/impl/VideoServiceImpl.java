package com.drill.edu.service.impl;

import com.drill.edu.entity.Video;
import com.drill.edu.mapper.VideoMapper;
import com.drill.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
