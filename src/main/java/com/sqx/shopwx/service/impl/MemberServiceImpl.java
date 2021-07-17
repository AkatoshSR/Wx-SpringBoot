package com.sqx.shopwx.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.MemberMapper;
import com.sqx.shopwx.pojo.MemberBean;
import com.sqx.shopwx.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberBean> implements MemberService {

    // 登录
    @Override
    public boolean login(MemberBean memberBean) {
        QueryWrapper<MemberBean> wrapper = new QueryWrapper<>();
        wrapper.eq("username", memberBean.getUsername());
        if (getOne(wrapper).getPassword().equals(memberBean.getPassword())){
            return true;
        }
        return false;
    }

    // 注册
    @Override
    public boolean register(MemberBean memberBean) {
        return save(memberBean);
    }

    // 修改信息
    @Override
    public boolean edit(MemberBean memberBean) {
        return updateById(memberBean);
    }

    // 获取用户列表
    @Override
    public List<MemberBean> getMemberList(MemberBean memberBean) {
        QueryWrapper<MemberBean> wrapper = new QueryWrapper<>();

        if (memberBean.getId() != null){
            wrapper.eq("id", memberBean.getId());
        }
        if (memberBean.getName() != null){
            wrapper.like("id", memberBean.getName());
        }
        if (memberBean.getMobile() != null){
            wrapper.like("mobile", memberBean.getMobile());
        }

        return list(wrapper);
    }

    // 注销用户
    @Override
    public boolean deleteMemberById(Integer id) {
        return removeById(id);
    }
}
