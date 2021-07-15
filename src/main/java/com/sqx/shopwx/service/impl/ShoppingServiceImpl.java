package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.ShoppingMapper;
import com.sqx.shopwx.pojo.ShoppingBean;
import com.sqx.shopwx.service.ShoppingService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl extends ServiceImpl<ShoppingMapper, ShoppingBean> implements ShoppingService {

    // 清空购物车
    @Override
    public boolean deleteAllShopping() {
        return remove(null);
    }

    // 添加订单到购物车
    @Override
    public boolean addShopping(ShoppingBean shoppingBean) {
        return save(shoppingBean);
    }

    // 根据id删除购物车
    @Override
    public boolean deleteShoppingById(Integer id) {
        return removeById(id);
    }
}
