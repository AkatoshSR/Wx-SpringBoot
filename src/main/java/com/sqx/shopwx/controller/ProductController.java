package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.ProductBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@Api(tags = "商品管理")
@RequestMapping("/product")
public class ProductController{

    @Autowired
    private ProductService productService;

    @ApiOperation("查询商品列表")
    @GetMapping("/list/{id}")
    public Result getProductList(@PathVariable Integer id){
        try {
            return Result.ok(productService.getProductList(id));
        }catch (Exception e){
            System.out.println("查询商品列表错误" + e);
        }
        return null;
    }

    @ApiOperation("添加商品")
    @PostMapping("/add")
    public Result addProduct(@RequestBody ProductBean productBean){
        try {
            return productService.addProduct(productBean) ? Result.ok() : Result.fail("添加商品失败");
        }catch (Exception e){
            System.out.println("添加商品错误" + e);
        }
        return null;
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/del")
    public Result deleteById(int id){
        try {
            return productService.deleteProductById(id) ? Result.ok() : Result.fail("删除商品失败");
        }catch (Exception e){
            System.out.println("删除商品错误" + e);
        }
        return null;
    }

    @ApiOperation("添加图片描述")
    @PostMapping("/logo")
    public Result logo(MultipartFile file){
        try {
            String fileName = productService.logo(file);
            return Result.ok("/shop/file/" + fileName);
        }catch (Exception e){
            System.out.println("添加图片描述" + e);
        }
        return null;
    }

    @ApiOperation("获取热卖商品")
    @GetMapping("/getHotProduct")
    public Result getHotProduct(){
        try {
            return Result.ok(productService.getHotProduct());
        }catch (Exception e){
            System.out.println("获取热卖商品错误" + e);
        }
        return null;
    }

}
