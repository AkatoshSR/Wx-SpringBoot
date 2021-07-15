package com.sqx.shopwx.controller;

import com.sqx.shopwx.pojo.CategoryBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "商品种类接口")
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取种类列表")
    @GetMapping("/getListByCategory/{category}")
    public Result listByCategory(@PathVariable String category){
        try{

            return Result.ok(categoryService.getListByCategory(category));
        }catch (Exception e){
            System.out.println("获取种类列表错误" + e);
        }
        return null;
    }

    @ApiOperation("根据id查询")
    @GetMapping("/getListById/{id}")
    public Result listById(@PathVariable Integer id){
        try {
            return Result.ok(categoryService.getListById(id));
        }catch (Exception e){
            System.out.println("查询id发生错误" + e);
        }
        return null;
    }


    @ApiOperation("修改操作")
    @PostMapping("/update")
    public Result update(@RequestBody CategoryBean categoryBean) {
        try {
            return categoryService.updateCategoryById(categoryBean) ? Result.ok() : Result.fail("修改失败");
        } catch (Exception e) {
            System.out.println("修改发生错误" + e);
        }
        return null;
    }

    @ApiOperation("增加操作")
    @PostMapping("/add")
    public Result add(@RequestBody CategoryBean categoryBean){
        try {
            return categoryService.addCategory(categoryBean) ? Result.ok() : Result.fail("插入失败");
        }catch (Exception e) {
            System.out.println("添加出现错误" + e);
        }
        return null;
    }

    @ApiOperation("删除操作")
    @DeleteMapping("/deleteById/{id}")
    public Result Delete(@PathVariable Integer id){
        try{
            return categoryService.deleteCategoryById(id) ? Result.ok() : Result.fail("删除失败");
        } catch (Exception e){
            System.out.println("删除时发生错误" + e);
        }
        return null;
    }

    @ApiOperation("分页条件查询")
    @PostMapping("/getListByPage/{current}/{limit}")
    public Result pageList(@PathVariable long current,
                           @PathVariable long limit,
                           @RequestBody(required = false) CategoryBean categoryBean){
        try {
            return Result.ok(categoryService.getListByPage(current, limit, categoryBean));
        }catch (Exception e){
            System.out.println("分页查询失败" + e);
        }
        return null;
    }

}
