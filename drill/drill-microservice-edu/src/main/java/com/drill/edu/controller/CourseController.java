package com.drill.edu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.common.vo.R;
import com.drill.edu.entity.*;
import com.drill.edu.service.*;

import com.drill.edu.vo.CommentVo;
import com.drill.edu.vo.CourseQuery;
import com.drill.edu.vo.ScoreQuery;
import com.drill.edu.vo.StuScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */

@RestController
@RequestMapping("/edu/course")
public class CourseController {

    @Autowired
    CommentService commentService;

    @Autowired
    MaterialService materialService;

    @Autowired
    CourseService courseService;
    @Autowired
    StuCourService stuCourService;
    @Autowired
    UserService userService;
    @Autowired
    HomeworkService homeworkService;
    @GetMapping("/getallcourse")
    public R selectAllCourse(@RequestParam long p, @RequestParam long limit){
        Page<Course> pageparam = new Page<>(p, limit);
        courseService.page(pageparam,null);
        if(pageparam!=null) return R.ok().data("items",pageparam.getRecords()).data("total",pageparam.getTotal());
        else return R.error();
    }

    @GetMapping("/findcoursesbystuid")
    public R findCourseByStuId(@RequestParam Integer id, @RequestParam long page, @RequestParam long limit){
        Page<StuCour> pageparam = new Page<>(page,limit);
        stuCourService.findCourseIdByStuId(id, pageparam);
        ArrayList<Integer> courseIds = new ArrayList<>();
        if(pageparam.getTotal()==0) return R.error();
        pageparam.getRecords().stream().map(item -> courseIds.add(item.getCourId())).collect(Collectors.toList());

        List<Course>courses = courseService.getByIds(courseIds);
        return R.ok().data("mycourses",courses ).data("total",pageparam.getTotal());

    }

    @GetMapping("/findbyparam")
    public R selectCourseByParam(CourseQuery cq, @RequestParam long page, @RequestParam long limit){
        Page<Course> pageparam = new Page<>(page,limit);
        courseService.findCourseByParam(cq,pageparam);
        if(pageparam!=null) return R.ok().data("items",pageparam.getRecords()).data("total",pageparam.getTotal());
        else return R.error();
    }

    @PostMapping("/insert")
    public R insertCourse(Course course){
        courseService.save(course);
        return R.ok();
    }

    @PutMapping("/update")
    public R updateCourse(Course course){
        courseService.updateById(course);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R deleteCourse(@RequestParam int id){
        courseService.removeById(id);
        return R.ok();
    }

    @GetMapping("/findallscore/{page}/{limit}")
    public R findAllScoreByCourseId(@RequestParam  Integer id, @PathVariable long page, @PathVariable long limit){
        Page<StuCour> pageparam = new Page<>(page, limit);
        stuCourService.findAllScoreByCourseId(pageparam,id);
        List<StuCour> records = pageparam.getRecords();
        List<StuScoreVo> res = new ArrayList<>();
        for(StuCour sc:records){
            StuScoreVo t = new StuScoreVo();
            t.setUCScore(sc.getUCScore());
            t.setUserName(userService.getById(sc.getUserId()).getUserName());
            res.add(t);
        }
        if(pageparam!=null) return R.ok().data("items", res).data("total",pageparam.getTotal());
        else return R.error();
    }

    @GetMapping("/findscorebyparam")
    public R findScoreByParam(ScoreQuery sq, @RequestParam long page, @RequestParam long limit){
        Page<StuCour> pageparam = new Page<>(page, limit);
        String name = sq.getUserName();
        List<Integer> userIds;
        if(StringUtils.isNotEmpty(name)) userIds = userService.findUserIdByName(name);
        else userIds = null;
        stuCourService.findScoreByParam(pageparam,sq, userIds);
        List<StuCour> records = pageparam.getRecords();
        if(records==null) return R.ok().data("items",null).data("total",pageparam.getTotal());
        List<StuScoreVo> res = new ArrayList<>();
        for(StuCour sc:records){
            StuScoreVo t = new StuScoreVo();
            t.setUCScore(sc.getUCScore());
            t.setUserName(userService.getById(sc.getUserId()).getUserName());
            res.add(t);
        }
        if(pageparam!=null) return R.ok().data("items",res).data("total",pageparam.getTotal());
        else return R.error();


    }

    @GetMapping("/findhomeworkbycourseid")
    public R findHomeWorkByCourseId(Integer id, long page, long limit){
        Page<Homework> pageparam = new Page<>(page, limit);
        homeworkService.findByCourseId(id,pageparam);
        if(pageparam!=null) return R.ok().data("items",pageparam.getRecords()).data("total",pageparam.getTotal());
        else return R.error();

    }

    @GetMapping("/findmaterialbycourseid")
    public R findMaterialByCourseId(Integer cid){
        List<Material> materials = materialService.findByCourseId(cid);
        if(materials!=null) return R.ok().data("items",materials);
        else return R.error();

    }

    @GetMapping("/findcommentbycourseid")
    public R findCommentByCourseId(Integer cid){
        List<Comment> comments = commentService.findByCourseId(cid);
     //   ArrayList<Integer> uids = new ArrayList<>();
  //      comments.forEach(item->uids.add(item.getUserId()));
  //      List<String> usernames = userService.findUserNameByIDs(uids);
        ArrayList<CommentVo> commentVos = new ArrayList<>();
        for(int i=0;i<comments.size();i++){
            CommentVo temp = new CommentVo();
            temp.setUserName(userService.getById(comments.get(i).getUserId()).getUserName());
            temp.setComId(comments.get(i).getComId());
            temp.setCreatime(comments.get(i).getCreatime());
            temp.setComDescr(comments.get(i).getComDescr());
            temp.setUserId(comments.get(i).getUserId());
            commentVos.add(temp);
        }

        if(commentVos!=null) return R.ok().data("items", commentVos);

        else return R.error();
    }




}

