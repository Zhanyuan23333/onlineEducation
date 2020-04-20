package com.drill.edu.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.drill.common.vo.R;
import com.drill.edu.entity.Homework;
import com.drill.edu.entity.StuHom;
import com.drill.edu.service.HomeworkService;
import com.drill.edu.service.StuHomService;
import com.drill.edu.utils.FileControll;
import com.drill.edu.vo.HomeWorkVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.PluginURLJarFileCallBack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/edu/homework")
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;
    @Autowired
    FileControll fileControll;
    @Autowired
    StuHomService stuHomService;



    @GetMapping("/gethomework")
    public R getHomework(Integer hid){
        Homework homework = homeworkService.getById(hid);
        if(homework!=null) return R.ok().data("item",homework);
        else return R.error();
    }

    @GetMapping("/gethomeworkbyuid")
    public R getHomeWorkByUid(Integer uid) {
        List<Integer> hids = stuHomService.getHomeWorkByUid(uid);
        if(hids==null || hids.size()==0) return R.error();
        List<Homework> homeworks = homeworkService.getByIds(hids);
        if(homeworks!=null||homeworks.size()!=0){
            return R.ok().data("items",homeworks);
        }else return R.error();
    }


    @PostMapping("/insert")
    public R insert(Homework homework, MultipartFile file, HttpServletRequest req){

        String path = fileControll.fileUpload(file,req,"homework");
        if(StringUtils.isNotEmpty(path)){
            homework.setHomFile(path);
        }
        homeworkService.save(homework);
        return R.ok();
    }

    @PostMapping("/updatefinishhomework")
    public R updateFinishHomeWork(Integer hid, Integer uid, MultipartFile file, HttpServletRequest req){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        StuHom stuHom = new StuHom();
        stuHom.setUHFtime(new Date());
        String path = fileControll.fileUpload(file,req,"homework");
        if(StringUtils.isNotEmpty(path)){
            stuHom.setUHFile(path);
            UpdateWrapper<StuHom> uw = new UpdateWrapper<>();
            uw.eq("user_id", uid);
            uw.eq("hom_id", hid);
            stuHomService.update(stuHom,uw);
            return R.ok();
        }else return R.error();

    }

    @PostMapping("/insertstudenthomework")
    public R insertStudentHomeWork(Integer uid, Integer hid){
        StuHom stuHom = new StuHom();
        stuHom.setHomId(hid);
        stuHom.setUserId(uid);
        stuHomService.save(stuHom);
        return R.ok();
    }

    @PutMapping("/update")
    public R update(Homework homework, MultipartFile file, HttpServletRequest req){
        String path = fileControll.fileUpload(file,req,"homework");
        if(StringUtils.isNotEmpty(path)){
            homework.setHomFile(path);
        }
        homeworkService.updateById(homework);
        return R.ok();
    }

    @DeleteMapping("/delete")
    public R delete(Integer id){
        homeworkService.removeById(id);
        return R.ok();
    }


    /*
    @GetMapping("/download")
    public R download(String filename, HttpServletResponse res, Integer id){
        Homework homework = homeworkService.getById(id);
        String downloadFilePath = homework.getHomFile();
        File file = new File(downloadFilePath);
        if(file.exists()){
            res.setContentType("application/force-download");
            res.addHeader("Content-Disposition", "attachment;fileName=" + filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = res.getOutputStream();
                int i = bis.read(buffer);
                while(i!=-1){
                    outputStream.write(buffer,0,i);
                    i = bis.read(buffer);
                }
                return R.ok();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(bis!=null){
                    try {
                        bis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(fis!=null){
                    try {
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return R.error();
    }

*/

}

