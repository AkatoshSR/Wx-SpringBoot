package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.OrderBean;

import java.util.List;

public interface OrderService extends IService<OrderBean> {

    // 获取订单列表
    List<OrderBean> getOrderList();

    // 创建列表
    boolean addOrder(OrderBean orderBean);

    // 根据用户名获取订单
    OrderBean getOrderByUsername(String username);

    // 根据用户id获取订单
    OrderBean getOrderById(Integer id);

    // 根据id删除订单
    boolean deleteOrder(Integer id);

}
