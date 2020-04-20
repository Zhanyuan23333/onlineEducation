package com.drill.edu.controller;


import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.drill.common.vo.R;
import com.drill.edu.entity.Homework;
import com.drill.edu.entity.Video;
import com.drill.edu.service.HomeworkService;
import com.drill.edu.service.VideoService;
import com.drill.edu.utils.FileControll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@RestController
@RequestMapping("/edu/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @Autowired
    FileControll fileControll;








    @PostMapping("/insert")
    public R insert(Video video, MultipartFile file, HttpServletRequest req) throws ClientException {
        String filename = fileControll.videoUpload1(file,req);
        String videoId = fileControll.videoUpload2(filename,video.getVidName());
        if(!"error".equals(videoId)){
            video.setVidFile(videoId);
            videoService.save(video);
            return R.ok();
        }else return R.error();
    }

    @PutMapping("/update")
    public R update(Video video, MultipartFile file, HttpServletRequest req) throws ClientException {
        String filename = fileControll.videoUpload1(file,req);
        String videoId = fileControll.videoUpload2(filename,video.getVidName());
        if(!"error".equals(videoId)){
            video.setVidFile(videoId);
        }
        videoService.updateById(video);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R delete(Integer id){
        videoService.removeById(id);
        return R.ok();
    }

}

