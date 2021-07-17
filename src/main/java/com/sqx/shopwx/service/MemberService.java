package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.MemberBean;

import java.util.List;

public interface MemberService extends IService<MemberBean> {

    // 会员登录
    boolean login(MemberBean memberBean);

    // 会员注册
    boolean register(MemberBean memberBean);

    // 会员填写/修改信息
    boolean edit(MemberBean memberBean);

    // 获取会员列表
    List<MemberBean> getMemberList(MemberBean memberBean);

    // 注销会员
    boolean deleteMemberById(Integer id);

}
