package com.drill.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.drill.common.vo.R;
import com.drill.edu.entity.Chapter;
import com.drill.edu.entity.Course;
import com.drill.edu.entity.Material;
import com.drill.edu.service.ChapterService;
import com.drill.edu.service.MaterialService;
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
@RequestMapping("/edu/chapter")
public class ChapterController {

    @Autowired
    ChapterService service;
    @Autowired
    MaterialService materialService;

    @PostMapping("/insert")
    public R insertCourse(Chapter chapter){
        service.save(chapter);
        return R.ok();
    }

    @PutMapping("/update")
    public R updateCourse(Chapter chapter){
        service.updateById(chapter);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R deleteCourse(@RequestParam int id){
        service.removeById(id);
        return R.ok();
    }

    @GetMapping("/findbycourse")
    public R findByCourseId(@RequestParam int id, @RequestParam long page, @RequestParam long limit){
        Page<Chapter> pageparam = new Page<>(page, limit);
        service.findALLChapterByCourse(id,pageparam);
        if(pageparam!=null) return R.ok().data("items",pageparam.getRecords()).data("total",pageparam.getTotal());
        else return R.error();
    }

    @GetMapping("findmaterialbychapter")
    public R findMaterialByChapter(Integer id, long page,long limit){
        Page<Material> pageparam = new Page<>(page, limit);
        materialService.findMaterialbyChapter(id,pageparam);
        if(pageparam!=null) return R.ok().data("items",pageparam.getRecords()).data("total",pageparam.getTotal());
        else return R.error();
    }

}

