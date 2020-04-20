package com.drill.edu.service;

import com.drill.edu.entity.StuHom;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zany
 * @since 2020-03-16
 */
public interface StuHomService extends IService<StuHom> {

    List<Integer> getHomeWorkByUid(Integer uid);

}
