package com.drill.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.drill.common.vo.R;
import com.drill.edu.entity.User;
import com.drill.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */

@RestController
@RequestMapping("/edu/user")
public class UserController {

    @Autowired
    UserService userService;

    //登录验证
    @GetMapping("/loginn")
    public R login(@RequestParam String phoneNum, @RequestParam String pwd){

        User u = userService.getByPhoneNum(phoneNum);
        if(u!=null){
            if(pwd.equals(u.getUserPwd())){
                return R.ok().data("type",u.getUserType()).data("id",u.getUserId());
            }
        }
         return R.error();
    }

    //验证用户名是否存在
    @GetMapping("/idexist")
    public R isIdExist(@RequestParam String phoneNum){

        QueryWrapper<User> w = new QueryWrapper<>();
        w.eq("user_phone",phoneNum);
        if(userService.count(w)!=0) return R.ok();
        else return R.error().data("type",-1);
    }

    //学生注册
    @PostMapping("/register")
    public R register(@RequestBody User stu){
   //     stu.setUserType(2);
        userService.save(stu);
        return R.ok();
    }

    @GetMapping("/findnamebyuid")
    public R findNameByUid(Integer uid){
        User user = userService.getById(uid);
        String username;
        if(user.getUserType()==2) username = user.getUserName()+"老师";
        else username = user.getUserName();
        return R.ok().data("name",username);

    }

}

