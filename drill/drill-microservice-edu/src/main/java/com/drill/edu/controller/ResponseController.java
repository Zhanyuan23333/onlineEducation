package com.drill.edu.controller;


import com.drill.common.vo.R;
import com.drill.edu.entity.Comment;
import com.drill.edu.entity.Response;
import com.drill.edu.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@RestController
@RequestMapping("/edu/response")
public class ResponseController {

    @Autowired
    ResponseService service;
    @PostMapping("/insert")
    public R insertCourse(Response response){
        service.save(response);
        return R.ok();
    }

    @PutMapping("/update")
    public R updateCourse(Response response){
        service.updateById(response);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R deleteCourse(@RequestParam int id){
        service.removeById(id);
        return R.ok();
    }

}

