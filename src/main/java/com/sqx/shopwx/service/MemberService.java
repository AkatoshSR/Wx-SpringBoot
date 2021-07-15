package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.MemberBean;

public interface MemberService extends IService<MemberBean> {

    // 会员登录
    boolean login(MemberBean memberBean);

    // 会员注册
    boolean register(MemberBean memberBean);

    // 会员填写/修改信息
    boolean edit(MemberBean memberBean);

}
