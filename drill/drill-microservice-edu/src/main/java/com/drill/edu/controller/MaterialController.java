package com.drill.edu.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.drill.common.vo.R;
import com.drill.edu.entity.Homework;
import com.drill.edu.entity.Material;
import com.drill.edu.service.HomeworkService;
import com.drill.edu.service.MaterialService;
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
@RequestMapping("/edu/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @Autowired
    FileControll fileControll;




    @PostMapping("/insert")
    public R insert(Material material, MultipartFile file, HttpServletRequest req){

        String path = fileControll.fileUpload(file,req,"material");
        if(StringUtils.isNotEmpty(path)){
            material.setMatFile(path);
        }
        materialService.save(material);
        return R.ok();
    }

    @PutMapping("/update")
    public R update(Material material, MultipartFile file, HttpServletRequest req){
        String path = fileControll.fileUpload(file,req,"material");
        if(StringUtils.isNotEmpty(path)){
            material.setMatFile(path);
        }
        materialService.updateById(material);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R delete(Integer id){
        materialService.removeById(id);
        return R.ok();
    }



}

