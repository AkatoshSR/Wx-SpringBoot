package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.UserBean;
import com.sqx.shopwx.result.Result;


public interface UserService extends IService<UserBean> {

    boolean Login(UserBean userBean);

}
