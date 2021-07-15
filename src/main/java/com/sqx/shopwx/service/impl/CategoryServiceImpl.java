package com.sqx.shopwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sqx.shopwx.mapper.CategoryMapper;
import com.sqx.shopwx.pojo.CategoryBean;
import com.sqx.shopwx.result.Result;
import com.sqx.shopwx.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryBean> implements CategoryService {

    // 根据category查询语句
    @Override
    public List<CategoryBean> getListByCategory(String category) {
        if (StringUtils.isBlank(category)){
            return list();
        } else{
            QueryWrapper<CategoryBean> wrapper = new QueryWrapper<>();
            wrapper.like("category", category);
            return list(wrapper);
        }
    }

    // 根据id查询
    @Override
    public List<CategoryBean> getListById(Integer id) {
        return list(new QueryWrapper<CategoryBean>().eq("id",id));
    }

    // 根据id修改category
    @Override
    public boolean updateCategoryById(CategoryBean categoryBean) {
        return updateById(categoryBean);
    }

    // 根据id删除
    @Override
    public boolean deleteCategoryById(Integer id) {
        return removeById(id);
    }

    // 增加数据
    @Override
    public boolean addCategory(CategoryBean categoryBean) {
        return save(categoryBean);
    }

    // 分页查询
    @Override
    public Page<CategoryBean> getListByPage(long current, long limit, CategoryBean categoryBean) {
        Page<CategoryBean> page = new Page<>(current, limit);
        // 构建条件
        QueryWrapper<CategoryBean> wrapper = new QueryWrapper<>();
        Integer id = categoryBean.getId();
        String category = categoryBean.getCategory();

        if (id != null){
            wrapper.eq("id", id);
        }
        if (category != null){
            wrapper.like("category", category);
        }
        Page<CategoryBean> categoryBeanPage = page(page, wrapper);
        return categoryBeanPage;
    }


}
