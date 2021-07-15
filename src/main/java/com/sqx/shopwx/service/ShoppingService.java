package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.ShoppingBean;

public interface ShoppingService extends IService<ShoppingBean> {

    // 清空购物车
    boolean deleteAllShopping();

    // 添加订单到购物车
    boolean addShopping(ShoppingBean shoppingBean);

    // 根据id删除购物车
    boolean deleteShoppingById(Integer id);

}
