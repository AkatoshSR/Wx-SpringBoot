package com.sqx.shopwx.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.MemberMapper;
import com.sqx.shopwx.pojo.MemberBean;
import com.sqx.shopwx.service.MemberService;
import org.springframework.stereotype.Service;

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
}
