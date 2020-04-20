package com.drill.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.drill.edu.entity.User;
import com.drill.edu.mapper.UserMapper;
import com.drill.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<Integer> findUserIdByName(String name) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("user_name", name);
        List<User> users = baseMapper.selectList(qw);
        List<Integer> res = new ArrayList<>();
        users.forEach(item->res.add(item.getUserId()));
        return res;
    }

    @Override
    public User getByPhoneNum(String phoneNum) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_phone",phoneNum);
        User user = baseMapper.selectOne(qw);
        return user;
    }

    @Override
    public List<String> findUserNameByIDs(ArrayList<Integer> uids) {
        List<User> users = baseMapper.selectBatchIds(uids);
        List<String> names = new ArrayList<>();
        users.forEach(item->names.add(item.getUserName()));
        return names;
    }
}
