package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.UserMapper;
import com.sqx.shopwx.pojo.UserBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserBean> implements UserService{

    // 登录
    @Override
    public boolean Login(UserBean userBean) {
        QueryWrapper<UserBean> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userBean.getUsername());
        UserBean result = getOne(wrapper);
        if (result.getPassword().equals(userBean.getPassword())){
            return true;
        }
        else {
            return false;
        }

    }
}
