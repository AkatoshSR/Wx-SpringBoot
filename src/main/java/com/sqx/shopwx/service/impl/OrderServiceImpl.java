package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.OrderMapper;
import com.sqx.shopwx.pojo.OrderBean;
import com.sqx.shopwx.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderBean> implements OrderService {

    // 获取订单列表
    @Override
    public List<OrderBean> getOrderList() {
        return list();
    }

    // 创建订单
    @Override
    public boolean addOrder(OrderBean orderBean) {
        return save(orderBean);
    }

    // 根据用户名获取订单
    @Override
    public OrderBean getOrderByUsername(String username) {
        QueryWrapper<OrderBean> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return getOne(wrapper);
    }

    // 根据id获取订单
    @Override
    public OrderBean getOrderById(Integer id) {
        QueryWrapper<OrderBean> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return getOne(wrapper);
    }

    // 删除订单
    @Override
    public boolean deleteOrder(Integer id) {
        return removeById(id);
    }

    // 订单列表
    @Override
    public List<OrderBean> getListBy(OrderBean orderBean) {
        QueryWrapper<OrderBean> wrapper = new QueryWrapper<>();
        if (orderBean.getId() != null){
            wrapper.eq("id", orderBean.getId());
        }
        if (orderBean.getName() != null){
            wrapper.like("name", orderBean.getName());
        }
        if (orderBean.getMobile() != null){
            wrapper.like("mobile", orderBean.getMobile());
        }
        return list(wrapper);
    }
}
