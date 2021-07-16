package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.CategoryBean;
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
public class ProductController {

    String fileName;

    @Autowired
    private ProductService productService;

    @ApiOperation("查询商品列表")
    @GetMapping("/list/{id}")
    public Result getProductList(@PathVariable Integer id) {
        try {
            return Result.ok(productService.getProductList(id));
        } catch (Exception e) {
            System.out.println("查询商品列表错误" + e);
        }
        return null;
    }

    @ApiOperation("根据id查询商品")
    @GetMapping("/getProductById/{id}")
    public Result getProductById(@PathVariable Integer id){
        try {
            return Result.ok(productService.getProductById(id));
        }catch (Exception e){
            System.out.println("查询错误" + e);
        }
        return null;
    }

    @ApiOperation("添加商品")
    @PostMapping("/add")
    public Result addProduct(@RequestBody ProductBean productBean) {
        try {
            return productService.addProduct(productBean) ? Result.ok() : Result.fail("添加商品失败");
        } catch (Exception e) {
            System.out.println("添加商品错误" + e);
        }
        return null;
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/del/{id}")
    public Result deleteById(@PathVariable Integer id) {
        try {
            return productService.deleteProductById(id) ? Result.ok() : Result.fail("删除商品失败");
        } catch (Exception e) {
            System.out.println("删除商品错误" + e);
        }
        return null;
    }

    @ApiOperation("修改商品")
    @PostMapping("/update")
    public Result updateProduct(@RequestBody ProductBean productBean){
        try {
            return productService.updateProduct(productBean) ? Result.ok(): Result.fail("修改失败");
        }catch (Exception e){
            System.out.println("修改商品错误"+e);
        }
        return null;
    }

    @ApiOperation("添加图片描述")
    @PostMapping("/logo")
    public Result logo(MultipartFile file) {
        try {

            fileName = productService.logo(file);
            System.out.println("/shop/file/" + fileName);

            return Result.ok("/shop/file/" + fileName);
        } catch (Exception e) {
            System.out.println("添加图片描述失败" + e);
        }
        return null;
    }

    @ApiOperation("修改图片描述")
    @PostMapping("/updateLogo")
    public Result updateLogo(@RequestBody ProductBean productBean){
        try {
            productBean.setLogo("/shop/file" + productBean.getLogo());
            return productService.updateLogo(productBean)? Result.ok():Result.fail("更改图片失败");
        }catch (Exception e){
            System.out.println("修改图片错误" + e);
        }
        return null;
    }

    @ApiOperation("修改图片")
    @PostMapping("/updateLogoPic")
    public Result updateLogoPic(@RequestBody ProductBean productBean){
        try {

        }catch (Exception e){

        }
        return null;
    }

    @ApiOperation("获取热卖商品")
    @GetMapping("/getHotProduct")
    public Result getHotProduct() {
        try {
            return Result.ok(productService.getHotProduct());
        } catch (Exception e) {
            System.out.println("获取热卖商品错误" + e);
        }
        return null;
    }

    @ApiOperation("分页条件查询")
    @PostMapping("/getListByPage/{current}/{limit}")
    public Result pageList(@PathVariable long current,
                           @PathVariable long limit,
                           @RequestBody(required = false) ProductBean productBean) {
        try {
            return Result.ok(productService.getListByPage(current, limit, productBean));
        } catch (Exception e) {
            System.out.println("分页查询失败" + e);
        }
        return null;
    }
}
