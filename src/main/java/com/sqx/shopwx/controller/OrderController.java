package com.sqx.shopwx.controller;


import com.sqx.shopwx.pojo.OrderBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "订单管理")
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("获得订单列表")
    @GetMapping("/getOrderList")
    public Result getOrderList(){
        try {
            return Result.ok(orderService.getOrderList());
        }catch (Exception e){
            System.out.println("获取订单列表发生错误" + e);
        }
        return null;
    }

    @ApiOperation("创建订单")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody OrderBean orderBean){
        try {
            return orderService.addOrder(orderBean) ? Result.ok() : Result.fail("创建订单失败");
        }catch (Exception e){
            System.out.println("创建订单发生错误" + e);
        }
        return null;
    }

    @ApiOperation("根据用户名获得订单")
    @GetMapping("/getOrderByUsername/{username}")
    public Result getOrderByUsername(@PathVariable String username){
        try{
            return Result.ok(orderService.getOrderByUsername(username));
        }catch (Exception e){
            System.out.println("获取订单错误" + e);
        }
        return null;
    }

    @ApiOperation("根据id获取订单")
    @GetMapping("/getOrderById/{id}")
    public Result getOrderById(@PathVariable Integer id){
        try {
            return Result.ok(orderService.getOrderById(id));
        }catch (Exception e){
            System.out.println("获取订单错误" + e);
        }
        return null;
    }

    @ApiOperation("根据id删除订单")
    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteOrderById(@PathVariable Integer id){
        try {
            return orderService.deleteOrder(id) ? Result.ok() : Result.fail("删除订单失败");
        }catch (Exception e){
            System.out.println("删除订单错误" + e);
        }
        return null;
    }


}
