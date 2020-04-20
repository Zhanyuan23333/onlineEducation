package com.drill.edu.service;

import com.drill.edu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface UserService extends IService<User> {
    public List<Integer> findUserIdByName(String name);

    public User getByPhoneNum(String phoneNum);

    List<String> findUserNameByIDs(ArrayList<Integer> uids);
}
