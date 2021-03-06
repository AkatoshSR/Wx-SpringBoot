package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.MemberBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "会员管理")
@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation("会员登录")
    @PostMapping("/login")
    public Result login(@RequestBody MemberBean memberBean) {
        try {
            return memberService.login(memberBean) ? Result.ok() : Result.fail("用户名或密码错误");
        } catch (Exception e) {
            return Result.fail("登录发生错误" + e);
        }
    }

    @ApiOperation("会员注册")
    @PostMapping("/register")
    public Result register(@RequestBody MemberBean memberBean) {
        try {
            return memberService.register(memberBean) ? Result.ok() : Result.fail("注册失败");
        } catch (Exception e) {
            return Result.fail("注册时发生错误" + e);
        }
    }

    @ApiOperation("会员填写/修改信息")
    @PostMapping("/edit")
    public Result edit(@RequestBody MemberBean memberBean) {
        try {
            return memberService.edit(memberBean) ? Result.ok() : Result.fail("填写信息失败");
        } catch (Exception e) {
            return Result.fail("信息填写错误" + e);
        }
    }

    @ApiOperation("获取会员列表")
    @PostMapping("/memberList")
    public Result getMemberList(@RequestBody(required = false) MemberBean memberBean) {
        try {
            return Result.ok(memberService.getMemberList(memberBean));
        } catch (Exception e) {
            return Result.fail("获取会员列表发生错误" + e);
        }
    }

    @ApiOperation("注销用户")
    @DeleteMapping("/delete/{id}")
    public Result deleteMemberById(@PathVariable Integer id) {
        try {
            return memberService.deleteMemberById(id) ? Result.ok() : Result.fail("注销用户失败");
        } catch (Exception e) {
            return Result.fail("注销用户发生错误" + e);
        }
    }


}
