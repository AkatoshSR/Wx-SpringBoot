package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.UserBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户登录管理")
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result Login(@RequestBody UserBean userBean){
        try{
            return userService.Login(userBean) ? Result.ok() : Result.fail("用户名或密码错误!!");
        }catch (Exception e){
            return Result.fail("用户名或密码错误!!");
        }
    }


}
