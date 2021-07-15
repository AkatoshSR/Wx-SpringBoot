package com.sqx.shopwx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sqx.shopwx.pojo.CategoryBean;

import java.util.List;

public interface CategoryService extends IService<CategoryBean> {

    // 根据category查询
    List<CategoryBean> getListByCategory(String category);

    // 根据id查询
    List<CategoryBean> getListById(Integer id);

    // 修改操作
    boolean updateCategoryById(CategoryBean categoryBean);

    // 根据id删除
    boolean deleteCategoryById(Integer id);

    // 添加操作
    boolean addCategory(CategoryBean categoryBean);

    // 分页查询
    Page<CategoryBean> getListByPage(long current, long limit, CategoryBean categoryBean);

}
