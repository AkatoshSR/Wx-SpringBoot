package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.ShoppingBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.ShoppingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "购物车管理")
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @ApiOperation("清空购物车")
    @DeleteMapping("/deleteAllShopping")
    public Result deleteAllShopping(){
        try {

        }catch (Exception e){
            System.out.println("清空购物车发生错误" + e);
        }
        return null;
    }

    @ApiOperation("添加订单到购物车")
    @PostMapping("/addShopping")
    public Result addShopping(@RequestBody ShoppingBean shoppingBean){
        try {

        }catch (Exception e){
            System.out.println("添加至购物车发生错误" + e);
        }
        return null;
    }

    @ApiOperation("根据id删除购物车")
    @DeleteMapping("/deleteShoppingById/{id}")
    public Result deleteShoppingById(@PathVariable Integer id){
        try {

        }catch (Exception e){
            System.out.println("根据id删除购物车发生错误" + e);
        }
        return null;
    }

}
