package com.drill.edu.controller;


import com.drill.common.vo.R;
import com.drill.edu.entity.Chapter;
import com.drill.edu.entity.Comment;
import com.drill.edu.entity.Response;
import com.drill.edu.service.CommentService;
import com.drill.edu.service.ResponseService;
import com.drill.edu.service.UserService;
import com.drill.edu.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@RestController
@RequestMapping("/edu/comment")
public class CommentController {

    @Autowired
    CommentService service;
    @Autowired
    ResponseService responseService;
    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public R insertCourse(Comment comment){
        service.save(comment);
        return R.ok();
    }

    @PutMapping("/update")
    public R updateCourse(Comment comment){
        service.updateById(comment);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R deleteCourse(@RequestParam int id){
        service.removeById(id);
        return R.ok();
    }

    @GetMapping("/findresponsebyid")
    public R findResponseById(Integer commentId){
        List<Response> responses = responseService.findResponseById(commentId);
        responses.sort((a,b)-> a.getCreatime().compareTo(b.getCreatime()));
        ArrayList<ResponseVo> responseVos = new ArrayList<>();
        responses.forEach(item->{
            ResponseVo temp = new ResponseVo();
            temp.setUserName1(userService.getById(item.getUserId1()).getUserName());
            temp.setUserName2(userService.getById(item.getUserId2()).getUserName());
            temp.setCreatime(item.getCreatime());
            temp.setResDescr(item.getResDescr());
            temp.setUserId1(item.getUserId1());
            temp.setUserId1(item.getUserId2());
            temp.setComId(item.getComId());
            responseVos.add(temp);
        });

        return R.ok().data("items", responseVos);
    }

}

